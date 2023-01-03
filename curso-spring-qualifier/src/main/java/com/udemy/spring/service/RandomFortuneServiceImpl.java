/**
 * 
 */
package com.udemy.spring.service;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * @author Julian
 *
 */
@Component
public class RandomFortuneServiceImpl implements FortuneService {

	@Override
	public String getFortune() {
		String[] array = { "random1", "random2", "random3" };

		Random random = new Random();
		int pos = random.nextInt(array.length);

		return array[pos];
	}

}
