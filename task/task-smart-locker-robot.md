* when 通过机器人存包
    * given 所有储物柜已满
        * then 存包失败
    * given 储物柜1有1个空位，储物柜2有2个空位
        * then 存包入第2个储物柜，输出票据
    * given 储物柜1有2个空位，储物柜2有1个空位
        * then 存包入第1个储物柜，输出票据
    * given 储物柜1有2个空位，储物柜2有2个空位
        * then 存包入第1个储物柜，输出票据

* when 通过机器人取包
    * given 正确票据 & 包裹存在第一个储物柜里
        * then 取包成功
    * given 正确票据 & 包裹存在第二个储物柜里
        * then 取包成功
    * given 作废票据
        * then 取包失败
    * given 无效票据
        * then 取包失败