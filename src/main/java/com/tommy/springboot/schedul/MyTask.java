package com.tommy.springboot.schedul;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


/*
 * 字段

允许值

允许的特殊字符

秒

0-59

, - * /

分

0-59

, - * /

小时

0-23

, - * /

日期

1-31

, - * ? / LWC

月份

1-12 或者 JAN-DEC

, - * /

星期

1-7 或者 SUN-SAT

, - * ? / LC #

年（可选）

留空, 1970-2099

, - * /

 

特殊字符：

在Cron表达式的时间字段中，除允许设置数值外，还能你使用一些特殊的字符，提供列表、范围、通配符等功能

星号(*)
可用在所有字段下，表示对应时间域名的每一个时刻，如*用在分钟字段，表示“每分钟”。

问号(?)
只能用在日期和星期字段，代表无意义的值，比如使用L设定为当月的最后一天，则配置日期配置就没有意义了，可用？作占位符的作用。

减号(-)
表示一个范围，如在日期字段5-10，表示从五号到10号，相当于使用逗号的5,6,7,8,9,10

逗号(,)
表示一个并列有效值，比如在月份字段使用JAN,DEC表示1月和12月

斜杠(/)
  x/y表示一个等步长序列，x为起始值，y为增量步长值，如在小时使用1/3
  相当于1,4,7,10当时用*  / y时，相当于0 / y



/*
 * 

L
L(Last)只能在日期和星期字段使用，但意思不同。在日期字段，表示当月最后一天，在星期字段，表示星期六（如果按星期天为一星期的第一天的概念，星期六就是最后一天。如果L在星期字段，且前面有一个整数值X，表示“这个月的最后一个星期X”，比如3L表示某个月的最后一个星期二。
W
选择离给定日期最近的工作日（周一至周五）。例如你指定“15W”作为day of month字段的值，就意味着“每个月与15号最近的工作日”。所以，如果15号是周六，则触发器会在14号（周五）触发。如果15号是周日，则触发器会在16号（周一）触发。如果15号是周二，则触发器会在15号（周二）触发。但是，如果你指定“1W”作为day of month字段的值，且1号是周六，则触发器会在3号（周一）触发。quartz不会“跳出”月份的界限。
LW组合
在日期字段可以组合使用LW,表示当月最后一个工作日（周一至周五）
井号(#)

只能在星期字段中使用指定每月第几个星期X。例如day of week字段的“6＃3”，就意味着“每月第3个星期五”（day3=星期五，＃3=第三个）；“2＃1”就意味着“每月第1个星期一”；“4＃5”就意味着“每月第5个星期3。需要注意的是“＃5”，如果在当月没有第5个星期三，则触发器不会触发。

C
只能在日期和星期字段中使用，表示计划所关联的诶其，如果日期没有被关联，相当于日历中的所有日期，如5C在日期字段相当于5号之后的第一天，1C在日期字段使用相当于星期填后的第一天
（4）cronExpression实例；

CRON表达式 含义
"0 0 12 * * ?"      每天中午十二点触发
"0 15 10 ? * *"    每天早上10：15触发
"0 15 10 * * ?"    每天早上10：15触发
"0 15 10 * * ? *"   每天早上10：15触发
"0 15 10 * * ? 2005"    2005年的每天早上10：15触发
“0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发
"0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发
"0 0/5 14,18 * * ?"     每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发
"0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发
"0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发
* "0 15 10 ? * MON-FRI"   每个周一、周二、周三、周四、周五的10：15触发
 *
 */

/*
 * 
 * 
 * 
 * 
 * 
   在国外有一个cron表达式生成器，地址是：http:/  /www.cronmaker.com  /

      妈妈在也不用担心我不会写cron表达式了。

      在此把常用的cron表达式双手奉上：

CRON表达式    含义

  "* /5 * * * * ? "    每隔5秒执行一次

"0 * /1 * * * ? "   每隔1分钟执行一次

"0 0 12 * * ?"    每天中午十二点触发

"0 0 23 * * ?"    每天23点执行一次

"0 0 1 * * ?"    每天凌晨1点执行一次

"0 0 1 1 * ?"    每月1号凌晨1点执行一次

"0 0 23 L * ?"    每月最后一天23点执行一次

"0 0 1 ? * L"    每周星期天凌晨1点实行一次

"0 26,29,33 * * * ?"    在26分、29分、33分执行一次

"0 0 0,13,18,21 * * ?"    每天的0点、13点、18点、21点都执行一次

"0 15 10 ? * *"    每天早上10：15触发

"0 15 10 * * ?"    每天早上10：15触发

"0 15 10 * * ? *"    每天早上10：15触发

"0 15 10 * * ? 2005"    2005年的每天早上10：15触发

“0 * 14 * * ?"    每天从下午2点开始到2点59分每分钟一次触发

"0 0/5 14 * * ?"    每天从下午2点开始到2：55分结束每5分钟一次触发

"0 0/5 14,18 * * ?"    每天的下午2点至2：55和6点至6点55分两个时间段内每5分钟一次触发

"0 0-5 14 * * ?"    每天14:00至14:05每分钟一次触发

"0 10,44 14 ? 3 WED"    三月的每周三的14：10和14：44触发

"0 15 10 ? * MON-FRI"    每个周一、周二、周三、周四、周五的10：15触发
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */


@Configuration
@EnableScheduling
public class MyTask {

	//@Scheduled(cron="0/6 * * * * *")
	public void task1() {
		System.out.println(">>>>>>>>>>>>task1111111111>>>>>>>>>>>>>>>>");
	}
	
	//@Scheduled(cron="0 0/1 * * * *")
	public void task2() {
		System.out.println(">>>>>>>>>>>>task2222222222>>>>>>>>>>>>>>>>");
	}
}
