* when存包
    * given 所有储物柜已满
        * then 存包失败
    * given 第一个储物柜未满
        * then 包裹存到第一个储物柜
    * given 第一个储物柜已满，第二个储物柜未满
        * then 包裹存到第二个储物柜

* when 取包
    * given 正确票据
        * then 取包成功
    * given 作废票据
        * then 取包失败
    * given 无效票据
        * then 取包失败