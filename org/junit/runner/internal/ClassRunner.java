package org.junit.runner.internal;

import org.junit.runner.Runner;


public abstract class ClassRunner extends Runner {

	private final Class<? extends Object> fTestClass;

	public ClassRunner(Class< ? extends Object> klass) {
		fTestClass= klass;
	}

	protected Class<? extends Object> getTestClass() {
		return fTestClass;
	}
}