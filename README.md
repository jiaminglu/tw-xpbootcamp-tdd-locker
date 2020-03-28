* WHEN 存包
	* GIVEN 柜子已满
		* THEN 存包失败
	* GIVEN 柜子未满
		* THEN 给出票据

* WHEN 取包
	* GIVEN 有效票据
		* THEN 取包成功
	* GIVEN 作废票据
	    * THEN 取包失败
	* GIVEN 无效票据
		* THEN 取包失败

## Test case

Given 柜子已满 When 存包 Then 存包失败

Given 柜子未满 When 存包 Then 给出票据

Given 有效票据 When 取包 Then 取包成功

Given 作废票据 When 取包 Then 取包失败

Given 无效票据 When 取包 Then 取包失败

