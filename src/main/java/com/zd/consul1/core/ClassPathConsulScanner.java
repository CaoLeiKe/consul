package com.zd.consul.core;

import com.zd.consul.methodProxy.ConsulProxy;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;

/**
 * spring容器动态添加接口的实现
 *
 * @Email caoleike@zoomdu.com
 * @User 曹磊科
 * @Time 2018/1/8 14:19
 */
public class ClassPathConsulScanner extends ClassPathBeanDefinitionScanner {

	// 被扫描的注解
	private Class<? extends Annotation> annotationClass;

	public ClassPathConsulScanner(BeanDefinitionRegistry registry) {
		super(registry, false);
	}

	public void setAnnotationClass(Class<? extends Annotation> annotationClass) {
		this.annotationClass = annotationClass;
	}


	// 扫描bean
	@Override
	public Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitions = super.doScan(basePackages);
		if (beanDefinitions.isEmpty()) {
			logger.warn("No ConsulInterface was found in '" + Arrays.toString(basePackages) + "' package. Please check your configuration.");
		} else {
			processBeanDefinitions(beanDefinitions);
		}
		return beanDefinitions;
	}

	// 处理扫描后的结果
	private void processBeanDefinitions(Set<BeanDefinitionHolder> beanDefinitions) {
		GenericBeanDefinition definition;
		for (BeanDefinitionHolder holder : beanDefinitions) {
			definition = (GenericBeanDefinition) holder.getBeanDefinition();
			if (logger.isDebugEnabled()) {
				logger.debug("Creating ConsulInterfaceFactoryBean with name '" + holder.getBeanName()
						+ "' and '" + definition.getBeanClassName() + "' ConsulInterface");
			}
			// the mapper interface is the original class of the bean
			// but, the actual class of the bean is ConsulProxy
			definition.getConstructorArgumentValues().addGenericArgumentValue(definition.getBeanClassName());
			definition.setBeanClass(ConsulProxy.class);
		}
	}

	// 设置是否是一个组件
	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface() && beanDefinition.getMetadata().isIndependent();
	}

	/**
	 * 判断是否与现有定义冲突，确定相应的bean定义是否需要注册
	 *
	 * @param beanName       bean的名称
	 * @param beanDefinition bean的定义
	 * @return true：确定注册，false：不需要注册
	 */
	@Override
	protected boolean checkCandidate(String beanName, BeanDefinition beanDefinition) {
		if (super.checkCandidate(beanName, beanDefinition)) {
			return true;
		} else {
			logger.warn("Skipping InterfaceFactoryBean with name '" + beanName
					+ "' and '" + beanDefinition.getBeanClassName() + "' ConsulInterface"
					+ ". Bean already defined with the same name!");
			return false;
		}
	}

	/**
	 * 注册扫描bean的过滤条件
	 */
	public void registerFilters() {
		// 标志
		boolean acceptAllInterfaces = true;

		// if specified, use the given annotation
		if (this.annotationClass != null) {
			addIncludeFilter(new AnnotationTypeFilter(annotationClass));
			acceptAllInterfaces = false;
		}

		// 如果没有设置注解，则扫描包下所有的接口
		if (acceptAllInterfaces) {
			// default include filter that accepts all classes
			addIncludeFilter(new TypeFilter() {
				@Override
				public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
					return true;
				}
			});
		}

		// exclude package-info.java
		addExcludeFilter(new TypeFilter() {
			@Override
			public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
				String className = metadataReader.getClassMetadata().getClassName();
				return className.endsWith("package-info");
			}
		});
	}

}
