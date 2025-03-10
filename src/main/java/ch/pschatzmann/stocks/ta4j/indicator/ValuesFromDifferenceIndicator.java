package ch.pschatzmann.stocks.ta4j.indicator;

import java.util.ArrayList;
import java.util.List;

import org.ta4j.core.Indicator;
import org.ta4j.core.TimeSeries;
import org.ta4j.core.num.Num;

/**
 * Calculates the absolute values from the differences
 * 
 * @author pschatzmann
 *
 */
public class ValuesFromDifferenceIndicator implements IIndicator<Num> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Num> result;
	private TimeSeries timeSeries;
	
	
	public ValuesFromDifferenceIndicator(double startValue, Indicator<Num> differences) {
		timeSeries = differences.getTimeSeries();
		result = new ArrayList();
		double value = startValue;
		result.add(this.numOf(value));
		for (int i=0;i<differences.getTimeSeries().getBarCount();i++) {
			value += differences.getValue(i).doubleValue();
			result.add(this.numOf(value));
		}
	}

	@Override
	public Num getValue(int index) {
		return result.get(index);
	}

	@Override
	public TimeSeries getTimeSeries() {
		return timeSeries;
	}

	@Override
	public Num numOf(Number number) {
		return timeSeries.numOf(number);
	}



}
