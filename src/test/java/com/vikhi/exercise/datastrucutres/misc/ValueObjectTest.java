package com.vikhi.exercise.datastrucutres.misc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.vikhi.pojo.Address;
import com.vikhi.pojo.BinaryNode;
import com.vikhi.pojo.MobileNumber;
import com.vikhi.pojo.NumberModel;
import com.vikhi.pojo.Student;
import com.vikhi.pojo.TempStudent;

@RunWith(Parameterized.class)
public class ValueObjectTest {
	
	private Class<?> clazz;
	
	public ValueObjectTest(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Parameters
	public static Collection<Object[]> params() {
		return Arrays.asList(new Object[][] {
			{Address.class},
			{MobileNumber.class},
			{Student.class}, 
			{TempStudent.class}, 
			{NumberModel.class}, 
			{BinaryNode.class}
		});
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testGettersAndSetters() {
		PojoClass pojo = PojoClassFactory.getPojoClass(clazz);
		Validator validator = ValidatorBuilder
				.create()
				.with(new SetterTester())
				.with(new GetterTester())
				.build();
		
		validator.validate(pojo);
		assertNotNull(pojo.getClass().hashCode());
		assertNotNull(pojo.getClass().toString());
		assertFalse(pojo.getClass().equals(PojoClassFactory.getPojoClass(clazz)));
	}
	
	
}
