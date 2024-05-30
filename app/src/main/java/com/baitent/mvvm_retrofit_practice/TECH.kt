package com.baitent.mvvm_retrofit_practice

/*

ROOM- Room, Android'in veri depolama çözümü olan SQLite üzerine kurulu bir kalıcılık (persistence) kütüphanesidir.

3 temel bileşenden oluşur entity dao database

ENTITY
Veritabanı tablosunu temsil eder.
Her Entity bir veritabanı tablosunu ifade eder ve her sütun bir alanı ifade eder.

DAO (Data Access Object):
Veritabanı erişim yöntemlerini tanımlar.
SQL sorgularını ve veritabanı işlemlerini içerir.

Database:
Veritabanını temsil eder ve veritabanı bağlantısını yönetir.
@Database anotasyonu ile tanımlanır ve RoomDatabase sınıfından türetilir.

---------------------------------------------------------------------------------------------------

KTX-  Android KTX bir eklenti, uzantı(extensions) olarak ifade edilebilir.

fun String.reverse(): String {
    return this.reversed()
}

val myString = "Hello"
val reversedString = myString.reverse()
println(reversedString)  // Output: olleH

---------------------------------------------------------------------------------------------------


MVVM - özellikle Android uygulama geliştirmede yaygın olarak kullanılan bir mimari desendir. Bu desen, uygulama kodunu daha okunabilir, test edilebilir ve sürdürülebilir hale getirir.

MVVM Mimarisi
MVVM, üç ana bileşenden oluşur:

Model:

Uygulamanın veri katmanıdır.
Veritabanı, ağ çağrıları ve diğer veri kaynaklarından gelen verileri içerir.
İş mantığı ve veri işleme burada gerçekleştirilir.
Model, ViewModel'e veri sağlar.

View:

Kullanıcı arayüzünü temsil eder.
XML dosyaları ve Activity/Fragment'lar bu katmanda bulunur.
ViewModel'den aldığı verileri kullanıcıya gösterir ve kullanıcı etkileşimlerini ViewModel'e iletir.

ViewModel:

Model ve View arasında bir köprü görevi görür.
Verileri işleyerek View için hazır hale getirir.
LiveData veya StateFlow gibi reaktif bileşenler kullanarak View'i günceller.
ViewModel, View'in yaşam döngüsünden bağımsızdır ve bu sayede daha dayanıklı ve test edilebilir hale gelir.

---------------------------------------------------------------------------------------------------

RETROFIT - Android'de RESTful web servislerine kolay ve verimli bir şekilde erişim sağlamak için kullanılan bir HTTP istemci kütüphanesidir

---------------------------------------------------------------------------------------------------

COROUTINES - Android Coroutines, Kotlin dilinde asenkron programlama ve paralel işlemleri basitleştirmek için kullanılan bir kütüphanedir. Kotlin Coroutines,
özellikle Android uygulamalarında ağ istekleri, veritabanı işlemleri ve
diğer uzun süreli görevler gibi bloklanmaya neden olabilecek işlemleri kolayca yönetmek için tasarlanmıştır.
farklı threadlerde işlemler yapmayı kolaylaştıran kotlin yapısı

Coroutines Temel Kavramları

CoroutineScope:

Coroutine'lerin yaşam döngüsünü yönetmek için kullanılır.
Bir scope, coroutines'lerin çalıştığı bir bağlam sağlar.
Android'de, genellikle CoroutineScope, ViewModel ve Activity sınıflarında kullanılır.

Job:

Bir coroutine'in yaşam döngüsünü temsil eder. Job, coroutine'in tamamlanmasını veya iptal edilmesini takip eder.

Dispatchers:

Coroutine'lerin hangi iş parçacığında çalışacağını belirler. Örneğin:
Dispatchers.Main: Ana iş parçacığında (UI thread) çalışır.
Dispatchers.IO: Giriş/çıkış (I/O) işlemleri için kullanılır.
Dispatchers.Default: CPU yoğun işlemler için kullanılır.

suspend fonksiyonları:

gerektiğinde durdurulup sonrasında tekrar devam ettirilebilen fonksiyonlar
suspend anahtar kelimesiyle tanımlanan fonksiyonlar, coroutine içinde çalışabilir ve diğer suspend fonksiyonlarını çağırabilir.
Bu fonksiyonlar, asenkron işlemleri senkronize kod gibi yazmanıza olanak tanır.



*/