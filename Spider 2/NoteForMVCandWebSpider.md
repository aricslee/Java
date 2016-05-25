## Note for MVC and WebSpider

### 1. MVC

the full name of MVC is Model-Viewer-Controller which is a kind of framework for developing dynamic web and something like that. The main idea behind this is to divide the interface(View) and data(Model), instead,using controller to deal with the communication of data and User(View). The advantages of this are can easy to improve the presentation and data without rewrite the controller.

The most common instance of Java MVC is the combination of JavaBean, Servlet and JSP(maybe antiquated) in which the javabean is model, the servlet is controller while th JSP is viewer

------



## 2. WebSpider

#### 1. the structure of my Spider

the **model**:

- News: hold the content of news and the picture and other informations. 
- NewsColumn:gathering the same theme news in a list and give them a same attributes
- Printer:print the news which have same theme and store as HTML in txt.
- Launcher:Using jsoup to get the perticular URL and using String analysis to get the content what I want from the html of the website to store at the News and NewsColumn.

#### 2. Several points

- JSoup:Jsoup is a tool which can get the content(Document) of website with its URL by the function of connect(URL).get().(PS: the method only supports the HTTP protocol)

- Document:Document is a class of Jsoup which is a container for the content of HTML, and you can remote kinds of methods to get what you want from it .

- connect method:create a new Connection according the URL. And Connection is a class which…..just like the API reference said 

  > A Connection provides a convenient interface to fetch content from the web, and parse them into Documents.

- Element:Element is some subcontinent from the html. You can using select() method with Document to choose the element with sepcific tag which is you want such as

  `src1 = Jsoup.connect(rootURls+currenturl).get();				`

  `Elements eles=src1.select("div.linews li.tag_title");`

  and you also can use select() method to a Element object to get the child element. Besides, you can use attr() method to element which is used to ...

  > public String attr(String attributeKey)
  > Get an attribute's value by its key.
  > To get an absolute URL from an attribute that may be a relative URL, prefix the key with abs, which is a shortcut to the absUrl(java.lang.String) method.
  >
  > E.g.:
  > String url = a.attr("abs:href");
  > Parameters:
  > attributeKey - The attribute key.
  > Returns:
  > The attribute, or empty string if not present (to avoid nulls).
  >

  #### 3. Lucene

  lucene is a framework of a hull content search engine, which is a little difficult for me, and the usage has been put in the official document clearly which also is the helper for this project

  ​

  ​



