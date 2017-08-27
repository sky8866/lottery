package com.sky.apps.action.lottery.web.engine.guilv;

import java.util.List;

import com.sky.modules.lottery.entity.guilv.Lottery;
/**
 * 连接的数字
 * @author samsung
 *
 */
public class AdditionUtils {
	
	/**
	 * 
	 * @param lotteries  开奖记录
	 * @param qi    期
	 * @param type   位置 
	 * @param sb
	 * @return
	 */
	
	
	public static int num(List<Lottery> lotteries, int qi, int type, StringBuffer sb) {
		int sum = 0;

		Integer[] l = { lotteries.get(qi).getNumber1(),
				lotteries.get(qi).getNumber2(), lotteries.get(qi).getNumber3(),
				lotteries.get(qi).getNumber4(), lotteries.get(qi).getNumber5(),
				lotteries.get(qi).getNumber6(), lotteries.get(qi).getNumber7() };
		sum = l[type];
		if (sb != null) {
			if (sb.length() > 1) {
				sb.delete(0, sb.length());

			}
			sb.append(qi).append(",").append(type);
		}

		return sum;
	}
}
