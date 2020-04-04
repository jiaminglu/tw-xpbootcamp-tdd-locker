* when 通过机器人存包
    * given 所有储物柜已满
        * then 存包失败
    * given 第一个储物柜未满
        * then 输出票据 & 包裹存到第一个储物柜
    * given 第一个储物柜已满，第二个储物柜未满
        * then 输出票据 & 包裹存到第二个储物柜

* when 通过机器人取包
    * given 正确票据 & 包裹存在第一个储物柜里
        * then 取包成功
    * given 正确票据 & 包裹存在第二个储物柜里
        * then 取包成功
    * given 作废票据
        * then 取包失败
    * given 无效票据
        * then 取包失败