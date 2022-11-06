# 							:sparkles:记录学习代码的各个阶段:sparkles:

>- **by 柒木**
>
>- **💬 微信：aqimu66（请备注事由）**

## 分层开发

分层开发是什么？

​	把一个Java项目中，所有的代码，根据其不同的用途和功能，以及面向的使用者的不同，把代码分为不同的包、层，用来区分代码之间的区别，提高代码的可维护性、可读性。

分层开发能分成哪些层？

​	按功能分：

​			**持久化层**(**dao**  |  **mapper**)：专门**与数据库进行交互**，这个层的所有类，主要功能都在与数据库进行交互。

​			**服务层**(**service**)：为用户提供服务，这个层是专门用来实现项目中的一些业务流程的层面，这个层的代码相对来说比较复杂，功能多种多样，但是都是为了**实现项目中的业务逻辑**。

​			**控制层**(**controller** | **handler**)：与用户进行交互的层，主要用来接收用户的请求，调用服务层完成用户的请求，并接收服务层的返回值，将数据进行基本处理后，把用户所需要的数据及视图，返回给用户。控制层有三个主要功能：**接收请求**，**调用处理方法**，**返回响应**。

​			**视图层**(**view**)：很有可能不在Java代码当中，视图层是用户看到的用户界面，用户在视图层进行操作，将数据发送给控制层，并接收控制层返回的响应数据，并将响应数据处理后，以视图的形式展现给用户。视图层可采用的技术有很多（JSP，Thymeleaf ， vue ，HTML ....）

​	有一些不在功能层面的类，如实体类、工具类、测试类、公用类、VO...，这些类通常会单独根据功能或用途进行分包。

​			**实体类包**(**entity** | **Pojo** | **domain** | **bean**)：这个包都是要构建实例对象的类，在现实或者功能中有具体的映射对象的类，比如：用户、班级、学校、动物、产品.....

​			**工具类包**(**util** | **tool**)：这个包主要用来放通用的工具，jdbc工具，字符串校验工具、加密工具....

1. 为什么要分层开发？

​		分层开发的优点：优化代码结构，让项目的可读性、可维护性、可扩展性在项目的结构上能变得更加优秀，让项目更加优雅。



## Web服务器

**web是什么？**在线的网页应用。

**服务器是什么？** 提供服务的网络处理器，是一台在网络上被公开的计算机。公开之后服务器有自己的地址(URL)，可以通过地址(URL)访问到服务器提供的服务。

**Web服务器是什么？**

​	并不是物理意义上的服务器，通常被理解为 **运行web应用的服务程序**，会被叫做 web应用服务器。web服务器本身也是应用程序，不过它可以用来运行其他web应用，所以被叫做web应用服务器。



## Web三大组件

### Servlet

​	Servlet是页面与Java后台交互的类，专门用来与视图层进行交互。Servlet可以做的事有：接收请求，处理请求，发送响应。

​	Servlet是特殊的Java类，有自己专门的接口和API，并不在JDK中包含，需要引入依赖Jar包。



#### 创建Servlet的方式

> 1. extends HttpServlet，并重写其中的doGet与doPost方法
> 2. implements Servlet，并实现其中的生命周期方法
> 3.

#### Servlet的生命周期

> 1. 初始化 init：只有在对应的url-pattern被首次调用时才会触发，并且只能触发一次。
> 2. 服务 service：每次对应的url-pattern被调用时都会触发
> 3. 销毁 distory：服务器关闭时会被触发

```xml
<web-app version="3.0"  
        xmlns="http://java.sun.com/xml/ns/javaee"  
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"  
        xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
		http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd">
</web-app>

```

### Filter过滤器

**Filter**是什么？

> 是用来对用户在页面上发出的请求进行拦截，并进行预处理，对后台向页面的响应进行拦截并进行预处理的工具。

过滤器的生命周期：

> * 实例化 -- 创建Filter过滤器对象，调用Filter的构造方法（构造器）
> * 初始化 -- 调用Filter中的init方法
> * 过滤 -- 调用 Filter中的 doFilter方法
> * 销毁 -- 调用 Filter中的 distory方法

第一个过滤器

```java
package com.dzqc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 该过滤器仅用于进行请求与响应的字符集设置。
 */
public class CharsetFilter implements Filter {

    /**
     *
     * @param request the <code>ServletRequest</code> object contains the client's request
     * @param response the <code>ServletResponse</code> object contains the filter's response
     * @param chain the <code>FilterChain</code> for invoking the next filter or the resource
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        通过过滤器链对象 chain 来调用下一步的方法，包括下一个过滤器以及下一个servlet
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("字符集过滤器被初始化了");
    }

    @Override
    public void destroy() {
        System.out.println("字符集过滤器被销毁了");
    }
}
```

过滤器配置

```xml
    <filter>
        <filter-name>charset</filter-name>
        <filter-class>com.dzqc.filter.CharsetFilter</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>charset</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

```

**Filter的创建方式只有一种**：实现 javax.servlet.Filter接口

### Listener监听器

Listener监听器主要监听的对象：

> **request**：监听器主要监听请求的创建与销毁
>
> **session**：监听器主要监听Session的创建销毁过程、Session的绑定过程、Session中属性创建、改变、删除，SessionId，Session行为监听
>
> **application**：主要监听 创建销毁、属性的创建、修改、删除

> **Request**：
>
> * ServletRequestListener ：主要用来监听Request的创建以及销毁
> * RequestAttributeListener：主要用来监听Request中的所有的 Attribute(属性)的状态，添加修改删除。
>
> **Session**：
>
> *

## JSP

JSP是什么？（**Java Server Pages** ）Java服务页面，JSP可以直接为用户提供服务支持，JSP页面其实是一个另类的Servlet。

### JSP页面的构成

> * HTML标签
> * 脚本
> * 指令



### JSP基本语法

#### 脚本

> **代码脚本**
>
> <%           Java代码            %>
>
> **输出脚本**
>
> <%=     Java代码中要输出的内容   %>
>
> **注释脚本**
>
> <%--  注释内容，不会被编译进页面   --%>
>
> **声明脚本**
>
> <%!		声明一个在页面中可以获取到的新变量      %>
>
> **指令脚本**
>
> <%@       使用JSP页面中专有的指令         %>



### JSP指令

> JSP指令一共有三种。
>
> * <%@ page  %>：用来声明或操作页面中的一些基本属性。
> * <%@ include  %>：包含指令，用来在一个页面中引入另一个页面的代码
> * <%@ taglib  %>：标签库指令，用来导入JSP页面的标准标签库信息。



### JSP内置对象

JSP的内置对象一共有9个。

> * **request**：请求对象。是一个HttpServletRequest类的实例对象
> * **response**：响应对象。是一个HttpServletResponse类的实例对象
> * **session**：会话对象。是一个HttpSession类的实例对象
    >   * session创建后不会自动关闭，但是可以手动关闭。
>   * session在未销毁之前，在页面中和后台的数据是共享的。
> * **application**：应用对象。是一个ServletContext类的实例对象。
> * **out**：输出对象，本质上是一个流
> * **page**：页面对象，每一个页面只有一个，指代页面本身。
> * **config**：配置对象，是一个ServletConfig类的实例对象。
> * **pageContext**：页面上下文对象。
> * **exception**：异常，错误对象。



### JSP页面跳转方式

> 转发：
>
> ​	**请求数据**：请求数据不会改变，转发之后请求数据可以实现共享。
>
> ​	**请求数量**：请求只有一个。
>
> ​	**操作的对象**：请求转发时，是通过请求进行操作的。
>
> ​	**地址栏**：地址栏内容只会改变一次，改变的值为后端接口的url
>
> ​	**目的地**：只能从后台接口跳转向后台接口。
>
> 重定向：
>
> **发起者**：由响应发起重定向
>
> **请求数量**：重定向操作的请求有两个。
>
> ​	**数据**：请求之间的数据不能共享。
>
> ​	**地址栏**：地址栏上的路径有两个，会进行两次路径跳转，一个路径是后台的请求路径，第二个路径是前端的页面路径。
>
> ​	**目的地**：重定向是在页面上发生的，是由一个页面跳向另一个页面。

### JSP作用域

作用：为了方便EL表达式取值，声明的作用域范围。

> 作用域一共有四种，由大到小分别为：
>
> * **application Scope**：应用程序作用域，范围为整个Web应用程序。
> * **session Scope**：会话作用域，范围为一次会话
> * **request Scope**：请求作用域，范围是一次请求，从请求发起，到响应完成。
> * **page Context Scope**：页面作用域，范围是一次页面请求，到请求结束。

## EL表达式与JSTL标准标签库

### EL表达式

EL表达式的基本语法：  **${}**

EL表达式的作用：用来简化页面输出方法以及取值方法。

EL表达式的适用范围：JSP页面上的非代码段的内容中。

EL表达式的使用前提：JSP页面要放开对EL表达式的支持。

EL表达式取值操作：指定作用域，只在指定的作用域中获取数据。

​								不指定作用域，由小到大开始向上遍历属性，找不到属性会返回null | ""

> EL表达式取值：
>
> * 基本类型（String\Integer....）：${属性名}
> * Map集合：${属性名.key值}      ${属性名.get(key)}
> * List集合：${属性名.get(index)}     ${属性名[index]}
> * 数组：${属性名[index]}
> * 对象：${属性名.对象属性名}

### JSTL标准标签库

JSTL作用：

> * 简化页面编写方式，主要优化的部分为：页面中带有基本逻辑结构的java代码，如：if判断结构、switch选择结构、循环结构。
> * 使用标签的形式实现了基本逻辑结构的功能，提高页面上代码的可读性，降低了Java代码对JSP页面的侵入，降低了页面的维护难度。
> * 为JSP页面开发提供了大量的标准化标签，降低开发难度。

JSTL的分类：

> 1. core核心标签库
> 2. format格式化标签库
> 3. sql标签库
> 4. 函数标签库
> 5. xml标签库

JSTL的使用前提：导入依赖

```xml
<dependency>
    <groupId>org.apache.taglibs</groupId>
    <artifactId>taglibs-standard-impl</artifactId>
    <version>1.2.5</version>
</dependency>
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

JSTL常用标签：

> * core:if  test: if标签中的test属性相当于java代码中if后括号中的判断条件
> * core:forEach:
    >   * items：需要循环的集合、数组
>   * var：循环时每次循环到的元素
>   * begin：循环开始的下标
>   * end：循环结束的下标
>   * step：循环时每次跳过的条数
>   * varStatus：变量基本属性
      >     * index：循环时每条数据所在的下标
>     * first：是否是第一条数据
>     * last：是否是最后一条
>     * count：获取当前需要循环的数组、集合中的总条数
>     * current：获取当前循环到的元素对象。
> * core:choose
    >   * core:when
>   * core:otherwise
      >     * 三个标签组成一组标签，功能与switch选择结构相同。choose为最外层标签，其中包含when，每一个when相当于一个switch中的case，otherwise相当于default
> * fmt:formatDate：格式化日期
    >   * var：未格式化的日期
>   * pattern：格式化日期的表达式





## 请求方式

**什么是请求？**

​	一个服务向另一个服务发送申请，以获取某些数据，或者说是前端向后台发送一个申请，去实现某个功能或获取某些目标数据。

​	请求就是服务或前端向另一个服务或后台发送申请的操作。在Java代码中，请求通常使用 request 来代表。

​	请求后返回的数据以及处理请求的操作，被叫做响应，响应通常使用 response 来代表。



想要处理请求，一定要有处理请求的服务的地址。在互联网环境下，一个服务要想被他人访问到，需要提供一个公开的地址，供他人访问。

> 例：https://www.baidu.com/
>
> 百度这个连接，所提供的访问路径叫做，域名 ，baidu.com。
>
> http \ https是网络协议，这两个同属于http协议。
>
> www. 属于网络协议。
>
> 真正的地址叫什么？是什么样的？
>
> ​	https://177.103.59.21:8088/baiduSearch
>
> 一个互联网地址，通常能够直接被访问的是域名，地址通常是被隐藏且被代理服务器代理的。
>
> 一个地址一定由  **http协议+ip地址+端口号+服务名+服务路径**，这个地址被称为**URL**。

**URL与请求的关系：**

* 请求一定是基于URL发送的。
* 请求的方式不同，URL也会有不同的状态。

**常用的请求方式：**

* Get请求：

    * > https://cn.bing.com/translator?ref=TThis&text=&from=en&to=zh-Hans
      >
      > get请求，特点是：
      >
      > 1. 请求过程中传输的参数都会展示在地址栏上。
      > 2. get请求发送数据有长度限制，最大数据长度为128K
      > 3. get请求的安全性不高，通常用于处理一些隐私度不高的需求。

* Post请求：

    * > 1. post请求过程中，所有的请求相关的数据，都会隐式发送，不会体现在地址栏上。
      > 2. post请求发送数据，没有数据长度限制。
      > 3. post请求安全性相对比较高，通常用于处理一些有敏感信息的请求。



## Session与Cookie

### Session

Session是什么？

> HTTP协议是一种无状态的协议。session主要是用来辅助HTTP协议对用户状态以及服务器状态进行记录的对象。

session的特性：

> * 每个客户端只持有一个Session。Session在客户端关闭之前或服务器关闭之前会一直存在。
> * Session与Session之间的数据不互通，每个Session都是一个独立的客户端与服务器之间的通信。
> * Session会自动关闭，自动关闭的条件是客户端长时间未进行操作（默认为30分钟<由Tomcat在conf目录的web.xml文件中进行设置>），服务器端会自动将Session会话关闭。

Session会话的最大超时时间：

> tips：最大超时时间的最小时间单位是分钟。
>
> 有三种设置方法：
>
> 1. Tomcat中，在conf文件夹下的web.xml配置文件下，有一个<session-config>标签，其中设置了最大超时时间30分钟
> 2. 项目的web.xml文件中，可以直接配置<session-config>，配置方式与Tomcat中的配置方式一致。
> 3. 代码中设置，使用HttpSession的实例对象，调用setMaxInactiveInterval() 方法进行设置

Session的属性设置

> * session可以实现会话中的属性共享，通过setAttribute方法进行属性设置，通过getAttribute方法进行属性获取。
> * 属性以键值对方式存在，在设置时需要设置String类型的属性名。同一属性名的属性只能在第一次设置时创建新属性，第二次及以后进行设置时，会覆盖同名的属性之前所设置的属性。
> * 所有的用户属性在设置之前，获取时都是null，设置之后获取的值可以为任意类型。

### Cookie

cookie是什么？

> cookie是一种以键值对形式将数据存储在客户端的数据存储工具。
>
> 主要是用来辅助HTTP协议对于客户端状态进行记录的工具。





## 反射



## 设计模式

### MVC设计模式



### 单例模式

## TIPS

1. 创建项目的步骤
    1. 建包
    2. 构建数据库
    3. 创建与数据库表对应的实体类
