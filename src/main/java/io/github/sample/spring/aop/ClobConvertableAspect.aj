package io.github.sample.spring.aop;

import io.github.sample.spring.jdbc.support.ClobConverterAware;
import io.github.sample.spring.jdbc.support.HibernateClobConverter;

/**
 * @author rveloso
 * @see org.springframework.beans.factory.aspectj.AbstractDependencyInjectionAspect
 */
public aspect ClobConvertableAspect {

	/**
	 * Select initialization join point as object construction
	 */
	public pointcut construction(ClobConverterAware bean) :
		execution(ClobConverterAware+.new(..)) && this(bean);
	 	//Use 'execution' instead to intercept object construction by reflection
		//initialization(ClobConverterAware+.new(..)) && this(bean);

	after(ClobConverterAware bean) returning : construction(bean) {
		bean.setClobConverter(new HibernateClobConverter());
	}

}
