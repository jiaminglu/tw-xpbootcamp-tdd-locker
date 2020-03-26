* WHEN 存包
	* GIVEN 柜子已满
		* 柜子剩余数不变
		* 不输出票据
	* GIVEN 票据未满
		* 柜子剩余数 - 1
		* 给出票据，以及柜子号

* WHEN 取包
	* GIVEN 票据有效
		* 返回柜子号
		* 柜子剩余数 + 1
		* 票据失效
	* GIVEN 票据无效
	  * 不返回柜子号
		* 柜子剩余数不变

## Test case

EXPECT 柜子剩余数不变并且输出票据为空 WHEN 存包 GIVEN 柜子已满

EXPECT 柜子剩余数-1并且给出票据，以及柜子号 WHEN 存包 GIVEN 票据未满

EXPECT 柜子剩余数 + 1, 返回柜子号 WHEN 取包 GIVEN 票据有效

EXPECT 票据失效 WHEN 取包 GIVEN 票据有效

EXPECT 柜子剩余数不变, 返回柜子号为空 WHEN 取包 GIVEN 票据无效
