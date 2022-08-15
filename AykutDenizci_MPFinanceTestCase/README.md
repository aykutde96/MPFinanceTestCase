
# MP Finance UI Project

Bu proje kapsamında aşağıdakiler kullanılmıştır.
- Java
- JUnit
- Selenium
- Gauge

Projeyi çalıştırabilmek için bilgisayarınızda yüklü olması gerekenler
- Java
- Maven
- Gauge

### BaseTest.class

BaseTest classı kullanacağım driver ayarlarını verdiğim, BeforeScenario ve AfterScenario anatosyanları ile testlerden önce driverı setlediğim, testlerden sonra driverı kapattığım classtır.
### BasePage.class

BasePage classı senaryolarda çok sık kullandığım metotları daha kısa hale getirip daha anlışılır kılmak amacıyla kullandığım bir class.
### Constants package

 Senaryolarda kullanmış olduğum String değerleri veya By tipindeki locator değerleri tuttuğum classların yer aldığı packagedir.
 ### Steps package

 Spec dosyasında kullanacağım senaryo adımlarının bulunduğu packagedir.

### specs klasörü
Step classında yazdığım senaryo adımlarını sıralı bir şekilde yazarak senaryo haline getirdiğim dosyaların bulunduğu klasör

### concepts klasörü
Specsler içine yazdığım adımları daha sade daha anlaşılır hale getirmek için kullandığım dosyaların bulunduğu klasör

 ## Helper
 ### CacheHelper
 Senaryoda ürün adını tutup ileriki adımlarda tekrardan kullanmak için oluşturmuş olduğum bir classtır.

## Senaryo

- Hepsiburada sitesine gidilir
- Arama alanına değer girilir
- Listelenen ürünlerden rastgele biri seçilir
- Ürün sepete eklenir
- Ürünün doğru bir şekilde sepete eklendiği kontrol edilir

### Bu senaryo 3 farklı ürün (pantolon, bilgisayar, roman) için çalıştırılmıştır. Bunun için gaugenin table özelliğinden faydalanılmıştır.