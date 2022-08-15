
# MP Finance API Project

Bu proje kapsamında aşağıdakiler kullanılmıştır.
- Java
- JUnit
- Rest Assured
- Gauge

Projeyi çalıştırabilmek için bilgisayarınızda yüklü olması gerekenler
- Java
- Maven
- Gauge

Ayrıca bu projede verilen istekleri daha efektif kullanabilmek için WireMock kütüphanesi kullanılarak servisler mocklanmıştır.

### ApiBase.class

ApiBase classı testlerimde kullanmış olduğum mock servislerin belirli ayarlarla ayağa kaldırılıp senaryolar bittikten sonra kapatıldığı classtır.
### ApiBaseMethods.class

ApiBaseMethods classı senaryolarda çok sık kullandığım metotları daha kısa hale getirip daha anlışılır kılmak amacıyla kullandığım bir class.
### Constants package

 Senaryolarda kullanmış olduğum String değerleri örneğin path, response mesajları gibi değerleri tuttuğum classın bulunduğu packagedir.
 ### Steps package

 Spec dosyasında kullanacağım senaryo adımlarının bulunduğu packagedir.

### specs klasörü
Step classında yazdığım senaryo adımlarını sıralı bir şekilde yazarak senaryo haline getirdiğim dosyaların bulunduğu klasör

### concepts klasörü
Specsler içine yazdığım adımları daha sade daha anlaşılır hale getirmek için kullandığım dosyaların bulunduğu klasör

 ## Resources
 ### __files
Senaryolarda get isteklerinde dönen cevabı yazdırabilmek için kullanılan json dosyalarının bulunduğu klasördür.

## API İstekleri

1-)
```http
  GET baseURL/allGrocery
```

| Parametre | Değer     | 
| :-------- | :------- |
| `statusCode` | `200` | 
| `dataSize` | `2` |

2-)
```http
  GET baseURL/allGrocery/1
```

| Parametre | Değer     | 
| :-------- | :------- |
| `statusCode` | `200` | 
| `id` | `1` |
| `name` | `apple` |
| `price` | `3` |
| `stock` | `100` |

3-)
```http
  GET baseURL/allGrocery/2
```

| Parametre | Değer     | 
| :-------- | :------- |
| `statusCode` | `200` | 
| `id` | `2` |
| `name` | `grapes` |
| `price` | `5` |
| `stock` | `50` |

4-)
```http
  GET baseURL/allGrocery/differentValue
```

| Parametre | Değer     | 
| :-------- | :------- |
| `statusCode` | `404` | 
| `status` | `Error` |
| `message` | `The grocery item does not found` |

5-)
```http
  POST baseURL/add
```

| Body Parametre | Değer     | 
| :-------- | :------- |
| `id` | `4` | 
| `name` | `strawberry` |
| `price` | `12.3` |
| `stock` | `3` |

| Request Parametre | Değer     | 
| :-------- | :------- |
| `status` | `Success` | 
| `message` | `Item has been added successfully` |

|status code| 200|
| :-------- | :------- |

6-)
```http
  POST baseURL/add
```

| Body Parametre | Değer     | 
| :-------- | :------- |
| `name` | `strawberry` |
| `price` | `12.3` |
| `stock` | `3` |

| Request Parametre | Değer     | 
| :-------- | :------- |
| `status` | `Error` | 
| `message` | `Id is required parameter` |

|status code| 400|
| :-------- | :------- |

7-)
```http
  POST baseURL/add
```

| Body Parametre | Değer     | 
| :-------- | :------- |
| `id` | `4` | 
| `price` | `12.3` |
| `stock` | `3` |

| Request Parametre | Değer     | 
| :-------- | :------- |
| `status` | `Error` | 
| `message` | `Name is required parameter` |

|status code| 400|
| :-------- | :------- |

8-)
```http
  POST baseURL/add
```

| Body Parametre | Değer     | 
| :-------- | :------- |
| `id` | `4` | 
| `name` | `strawberry` |
| `stock` | `3` |

| Request Parametre | Değer     | 
| :-------- | :------- |
| `status` | `Error` | 
| `message` | `Price is required parameter` |

|status code| 400|
| :-------- | :------- |

9-)
```http
  POST baseURL/add
```

| Body Parametre | Değer     | 
| :-------- | :------- |
| `id` | `4` | 
| `name` | `strawberry` |
| `price` | `12.3` |

| Request Parametre | Değer     | 
| :-------- | :------- |
| `status` | `Error` | 
| `message` | `Stock is required parameter` |

|status code| 400|
| :-------- | :------- |

