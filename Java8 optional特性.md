                                                         #### Java8 optional 常用特性



##### 一. lambda 表达式

> java8 发布于2014年，相比于java7，java8新增了很多特性，比如lambda函数式接口、f方法引用、默认方法、Date Time Api、streamApi、optional等。
>
> 

##### 二.  Optional 简介

> Optional类是Java8为了解决null值判断问题，借鉴google guava类库的Optional类而引入的一个同名Optional类，使用Optional类可以避免显式的null值判断（null的防御性检查），避免null导致NPE（NullPointerException）。

- 代码示例

  1. 未使用optional

     ```java
     // 获取系统用户名的方法，方法入参为一个SysUser实例，为了防止user对象为null，做了防御性检查：如果为null，返回"Unkown"，
     public static String getUserName(SysUser user)
         {
             if(null == user)
             {
                 return "Unkown";
             }
             return user.getUserName();
         }
     ```

  2. 使用optional优化后

     ```java
     public static String getUserName(SysUser user){
         return Optional.ofNullable(user).map(u -> u.getUserName).orElse("Unkown");
     }
     ```

     

##### 三.  Optional对象的创建



##### 四.  类典型接口的使用



##### 五.  注意事项

