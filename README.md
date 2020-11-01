# KDK, Default Project Template


## **E**nvironment

* Open JDK v1.8.0
* BackEnd :: Spring Boot
* FrontEnd :: React JS

## Install

#### 1. Open JDK 1.8.0 Install

* JDK Install

```bash
$ yum install java-1.8.0-openjdk
$ yum install java-1.8.0-openjdk-devel
```

* 환경변수 등록

  * location =&gt; /usr/bin/java

  ```text
  //# vi /etc/profile

  ...

  JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-1.8.0.242.b08-0.el7_7.x86_64
  PATH=$PATH:$JAVA_HOME/bin
  CLASSPATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar

  export JAVA_HOME PATH CLASSPATH
  ```

#### 2. Nginx Install

* 외부 저장소 추가
  * vi /etc/yum.repos.d/nginx.repo

```bash
[nginx]
name=nginx repo
baseurl=http://nginx.org/packages/centos/7/$basearch/
gpgcheck=0
enabled=1
```

* yum install

```bash
$ yum install -y nginx
```

* Nginx location 설정
  * vi /etc/nginx/conf.d/default.conf

```bash
location / {
    root   ${project folder location };
    index  ${location };
}
```

* Nginx Port 설정
  * vi /etc/nginx/conf.d/default.conf

```bash
listen 80;  ->  listen 8089;
```

## **START**

```bash
$ java -jar ./**.jar
$ systemctl start nginx
```

## **Etc**

* ERD Cloud \()\)

### [BackEnd Document](https://github.com/kdkrkwhr/default-template/blob/master/backend/README.md)

### [FrontEnd Document](https://github.com/kdkrkwhr/default-template/blob/master/frontend/README.md)

