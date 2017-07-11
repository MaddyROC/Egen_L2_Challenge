package io.egenchallenge.pwtstarter.ruleTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.egenchallenge.pwtstarter.dao.MetricDao;
import io.egenchallenge.pwtstarter.model.Metric;
import io.egenchallenge.pwtstarter.ruleFactory.OverWtRule;
import io.egenchallenge.pwtstarter.ruleFactory.UnderWtRule;

public class RulesTest {

	@Mock
	MetricDao metricRepoDao = new MetricDao();
	
	OverWtRule overWt;
	UnderWtRule underWt;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		overWt = new OverWtRule();
		underWt = new UnderWtRule();
	}
	
//	@Test
//	public void testUnderWeightRulegtThan() {
//		Metric metricCurrent = new Metric();
//		metricCurrent.setValue(139);
//		Mockito.when(metricRepoDao.getRecentWeight("-timeStamp")).thenReturn(metricCurrent);
//
//		Assert.assertTrue(underWt.checkOWR());
//	}
	
//	@Test
//	public void testUnderWeightRulelsThan() {
//		Metric metricCurrent = new Metric();
//		metricCurrent.setValue(142);
//		Mockito.when(metricRepoDao.getRecentWeight("-timeStamp")).thenReturn(metricCurrent);
//
//		Assert.assertTrue(underWt.checkOWR());
//	}
	
//	@Test
//	public void testOverWeightRulegtThan() {
//		Metric metricCurrent = new Metric();
//		metricCurrent.setValue(246);
//		Mockito.when(metricRepoDao.getRecentWeight("-timeStamp")).thenReturn(metricCurrent);
//
//		Assert.assertFalse(overWt.checkOWR());
//	}
	
//	@Test
//	public void testOverWeightRulelsThan() {
//		Metric metricCurrent = new Metric();
//		metricCurrent.setValue(141);
//		Mockito.when(metricRepoDao.getRecentWeight("-timeStamp")).thenReturn(metricCurrent);
//
//		Assert.assertFalse(overWt.checkOWR());
//	}

}
