# LAB A4 - Máy tính bốn phép toán & Tính chỉ số BMI

> Ứng dụng Android thực hành `TextView`, `Button`, `EditText`, xử lý sự
> kiện, kiểm tra dữ liệu và bẫy ngoại lệ bằng Java. Project gồm **máy
> tính bốn phép toán**, **tính BMI** và hai bài nâng cao **NC1 -- phần
> trăm/đảo dấu** và **NC2 -- lịch sử 5 phép tính gần nhất**.

## Mục lục

-   [1. Thông tin sinh viên và dự án](#1-thông-tin-sinh-viên-và-dự-án)
-   [2. Giới thiệu dự án](#2-giới-thiệu-dự-án)
-   [3. Mục tiêu thực hành](#3-mục-tiêu-thực-hành)
-   [4. Công nghệ và môi trường](#4-công-nghệ-và-môi-trường)
-   [5. Các tính năng chính](#5-các-tính-năng-chính)
-   [6. Hai bài nâng cao](#6-hai-bài-nâng-cao)
-   [7. Kiểm tra và xử lý dữ liệu](#7-kiểm-tra-và-xử-lý-dữ-liệu)
-   [8. Cấu trúc dự án](#8-cấu-trúc-dự-án)
-   [9. Cài đặt và chạy ứng dụng](#9-cài-đặt-và-chạy-ứng-dụng)
-   [10. Hướng dẫn sử dụng](#10-hướng-dẫn-sử-dụng)
-   [11. Kiểm thử](#11-kiểm-thử)
-   [12. Git và GitHub](#12-git-và-github)
-   [13. Kết quả hoàn thành](#13-kết-quả-hoàn-thành)
-   [14. Kết luận](#14-kết-luận)

## 1. Thông tin sinh viên và dự án

| Thông tin | Nội dung |
|---|---|
| Họ và tên | **Nguyễn Thị Hồng Thắm** |
| Mã số sinh viên | **241A010134** |
| Lớp | **261INT421104** |
| Trường | **Đại học Văn Hiến** |
| Khoa | **Công nghệ Thông tin** |
| Học phần | **Lập trình trên các thiết bị di động (INT4211)** |
| Bài thực hành | **Lab A4 – TextView, Button, EditText & xử lý sự kiện** |
| Tên ứng dụng | `A4_241A010134` |
| Package | `vn.edu.vhu.ltdd.a4events` |
| Ngôn ngữ | **Java** |
| Giao diện | **Android XML Layout** |
| Minimum SDK | **API 24 – Android 7.0** |
| Bài nâng cao thực hiện | **NC1 – Thêm % và đảo dấu (±); NC2 – Lưu lịch sử 5 phép tính gần nhất** |

## 2. Giới thiệu dự án

**A4_241A010134** là ứng dụng Android được xây dựng để thực hành cách
ánh xạ View, gán bộ lắng nghe sự kiện cho `Button`, đọc dữ liệu từ
`EditText`, chuyển chuỗi sang số, kiểm tra dữ liệu và xử lý ngoại lệ
bằng `try-catch`.

Ứng dụng được chia thành hai chức năng chính:

-   **Máy tính:** thực hiện bốn phép toán cộng, trừ, nhân và chia trên
    hai số thực.
-   **BMI:** tính chỉ số BMI từ cân nặng và chiều cao, sau đó phân loại
    kết quả.

Giao diện được đặt trong `ScrollView` để có thể cuộn khi nội dung dài
hoặc bàn phím chiếm không gian màn hình. Phần máy tính sử dụng hai
`EditText`, các `Button` phép toán và `TextView` hiển thị kết quả/lịch
sử; phần BMI sử dụng hai ô nhập, nút tính và vùng hiển thị BMI cùng phân
loại.

Ngoài yêu cầu cơ bản, project triển khai hai bài nâng cao:

-   **NC1:** thêm nút `%` và `±` cho máy tính.
-   **NC2:** lưu và hiển thị 5 phép tính gần nhất bằng
    `ArrayList<String>`, đồng thời lưu trạng thái lịch sử khi Activity
    được tạo lại do xoay màn hình.

## 3. Mục tiêu thực hành

Lab A4 hướng đến các mục tiêu chính:

-   Ánh xạ View trong XML sang đối tượng Java bằng `findViewById()`.
-   Gán bộ lắng nghe sự kiện cho `Button` bằng biểu thức lambda và
    listener dùng chung.
-   Đọc dữ liệu từ `EditText` và xử lý chuỗi bằng `trim()`.
-   Chuyển dữ liệu chuỗi sang `double` bằng `Double.parseDouble()`.
-   Áp dụng quy trình kiểm tra dữ liệu: **rỗng → định dạng → miền giá
    trị → nghiệp vụ**.
-   Bẫy `NumberFormatException` bằng `try-catch`.
-   Báo lỗi bằng `setError()` và `Toast`.
-   Định dạng số bằng `String.format()` kết hợp `Locale.getDefault()`.
-   Thực hành `ArrayList<String>` và `Bundle` để lưu trạng thái.
-   Kiểm thử ứng dụng với cả dữ liệu hợp lệ và dữ liệu lỗi.
-   Quản lý mã nguồn bằng Git và GitHub.

## 4. Công nghệ và môi trường

| Thành phần | Công nghệ / phiên bản |
|---|---|
| IDE sử dụng | Android Studio Quail 4 \| 2026.1.4 |
| Ngôn ngữ lập trình | Java |
| Giao diện | Android XML Layout (`ScrollView`, `LinearLayout`, `TextView`, `EditText`, `Button`) |
| Build system | Gradle, Kotlin DSL (`.gradle.kts`) |
| Minimum SDK | API 24 – Android 7.0 |
| Android framework | AndroidX AppCompat |
| Xử lý sự kiện | Lambda Expression, `View.OnClickListener` |
| Xử lý dữ liệu | `Double.parseDouble()`, `try-catch`, `setError()`, `Toast` |
| Định dạng kết quả | `String.format()`, `Locale.getDefault()` |
| Lưu lịch sử | `ArrayList<String>` |
| Lưu trạng thái | `Bundle`, `onSaveInstanceState()` |
| Công cụ kiểm tra | Android Emulator, Logcat |
| Quản lý mã nguồn | Git + GitHub |

Project sử dụng `EdgeToEdge` và `WindowInsetsCompat` để xử lý vùng
system bars, đồng thời sử dụng `Locale.getDefault()` khi định dạng kết
quả số.

## 5. Các tính năng chính

### 5.1. Máy tính bốn phép toán

Ứng dụng nhận hai số từ:

-   `edtSoA` -- số thứ nhất.
-   `edtSoB` -- số thứ hai.

Bốn phép toán cơ bản:

Nút   Phép toán   Ký tự xử lý
  ----- ----------- -------------
`+`   Cộng        `'+'`
`−`   Trừ         `'-'`
`×`   Nhân        `'*'`
`÷`   Chia        `'/'`

Nút cộng và trừ sử dụng listener riêng; nút nhân và chia sử dụng một
`View.OnClickListener` chung và phân biệt thao tác bằng `v.getId()`.

Phương thức chính:

``` java
private void tinhToan(char phepToan)
```

thực hiện quy trình:

``` text
Đọc A, B
   ↓
Kiểm tra rỗng
   ↓
Chuyển String → double
   ↓
Bẫy lỗi định dạng
   ↓
Kiểm tra chia cho 0
   ↓
Thực hiện phép toán
   ↓
Định dạng kết quả
   ↓
Hiển thị + lưu lịch sử
```

Kết quả được định dạng với hai chữ số thập phân. Khi số thứ hai âm, ứng
dụng đặt số đó trong ngoặc để biểu thức dễ đọc, ví dụ:

``` text
5.00 - (-2.00) = 7.00
```

### 5.2. Xóa dữ liệu máy tính

Nút **Xóa trắng** gọi:

``` java
private void xoaTrang()
```

để:

-   Xóa nội dung hai ô số.
-   Xóa trạng thái lỗi cũ của hai `EditText`.
-   Đưa dòng kết quả về `Kết quả: —`.
-   Đưa con trỏ về ô số thứ nhất.

Lịch sử phép tính được giữ riêng, không bị xóa khi chỉ làm trắng hai ô
nhập.

### 5.3. Tính BMI

Phương thức:

``` java
private void tinhBmi()
```

đọc cân nặng và chiều cao, sau đó tính:

``` text
BMI = cân nặng (kg) / chiều cao² (m)
```

Ứng dụng chấp nhận chiều cao theo hai dạng:

``` text
1.70 m
170 cm
```

Nếu chiều cao lớn hơn `3`, chương trình hiểu dữ liệu đang ở đơn vị
centimet và tự chia cho `100.0` trước khi tính.

### 5.4. Phân loại BMI

Kết quả được phân loại bởi:

``` java
private String phanLoai(double bmi)
```

theo các ngưỡng được sử dụng trong bài:

              BMI Phân loại
  --------------- -------------
         `< 18.5` Thiếu cân
    `18.5 – < 23` Bình thường
      `23 – < 25` Thừa cân
           `≥ 25` Béo phì

Kết quả BMI được hiển thị với một chữ số thập phân:

``` text
BMI = 21.5
Bình thường
```

## 6. Hai bài nâng cao

### 6.1. NC1 -- Thêm phần trăm (%) và đảo dấu (±)

NC1 mở rộng máy tính bằng hai nút:

``` text
±    %
```

#### Đảo dấu `±`

Phương thức:

``` java
private void daoDau()
```

xác định ô nhập đang được chọn bằng `hasFocus()`.

Giá trị hiện tại được đọc và chuyển sang `double`, sau đó nhân với `-1`:

``` java
so = so * (-1);
```

Ví dụ:

``` text
5   → -5
-5  → 5
2.5 → -2.5
```

Nếu kết quả là số nguyên, chương trình hiển thị không kèm `.0`. Sau khi
thay đổi, con trỏ được đưa về cuối nội dung bằng `setSelection()`.

#### Phần trăm `%`

Phương thức:

``` java
private void phanTram()
```

cũng tác động lên ô số đang được chọn. Giá trị được chia cho `100.0`:

``` text
50  → 0.5
25  → 0.25
500 → 5
```

Cả hai chức năng đều kiểm tra ô trống và bẫy lỗi chuyển đổi số.

### 6.2. NC2 -- Lịch sử 5 phép tính gần nhất

Lịch sử được lưu bằng:

``` java
ArrayList<String> lichSu = new ArrayList<>();
```

Sau mỗi phép tính hợp lệ, chuỗi kết quả được đưa vào đầu danh sách:

``` java
lichSu.add(0, phepTinh);
```

Nếu số phần tử vượt quá `5`, phần tử cũ nhất ở cuối danh sách được xóa:

``` java
if (lichSu.size() > 5) {
    lichSu.remove(lichSu.size() - 1);
}
```

Nhờ đó, `tvLichSu` luôn hiển thị tối đa **5 phép tính gần nhất**, với
phép mới nhất nằm trên cùng.

Phương thức:

``` java
private void hienThiLichSu()
```

dùng `StringBuilder` để ghép các phép tính thành nội dung hiển thị.

#### Lưu lịch sử khi xoay màn hình

Project sử dụng:

``` java
private static final String KEY_LICH_SU = "lich_su";
```

và lưu danh sách trong:

``` java
@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putStringArrayList(KEY_LICH_SU, lichSu);
}
```

Khi Activity được tạo lại, danh sách được lấy từ `savedInstanceState` và
hiển thị trở lại. Cơ chế này giúp lịch sử không bị mất khi thay đổi cấu
hình như xoay màn hình.

## 7. Kiểm tra và xử lý dữ liệu

### 7.1. Kiểm tra dữ liệu máy tính

Ứng dụng không thực hiện phép tính ngay sau khi đọc dữ liệu mà kiểm tra
theo từng lớp.

**Rỗng**

``` java
if (chuoiA.isEmpty()) {
    edtSoA.setError(getString(R.string.err_empty));
    edtSoA.requestFocus();
    return;
}
```

**Định dạng**

``` java
try {
    a = Double.parseDouble(chuoiA);
    b = Double.parseDouble(chuoiB);
} catch (NumberFormatException e) {
    Toast.makeText(this, R.string.err_not_number, Toast.LENGTH_SHORT).show();
    return;
}
```

**Nghiệp vụ chia cho 0**

``` java
if (phepToan == '/' && b == 0) {
    edtSoB.setError(getString(R.string.err_divide_zero));
    Toast.makeText(this, R.string.err_divide_zero, Toast.LENGTH_SHORT).show();
    return;
}
```

Nhờ các lệnh `return`, chương trình dừng xử lý ngay khi phát hiện dữ
liệu không hợp lệ.

### 7.2. Kiểm tra dữ liệu BMI

BMI yêu cầu cân nặng và chiều cao lớn hơn `0`:

``` java
if (canNang <= 0 || chieuCao <= 0) {
    Toast.makeText(this, R.string.err_positive, Toast.LENGTH_SHORT).show();
    return;
}
```

Dữ liệu không chuyển được sang số được xử lý bằng
`NumberFormatException`.

### 7.3. `setError()` và `Toast`

Project kết hợp hai cách báo lỗi:

-   `setError()` phù hợp khi có thể xác định chính xác ô nhập gây lỗi.
-   `Toast` phù hợp cho thông báo chung hoặc lỗi cần người dùng chú ý
    ngay.

### 7.4. Định dạng với `Locale`

Kết quả phép tính sử dụng:

``` java
String.format(Locale.getDefault(), ...)
```

để việc định dạng số phù hợp với thiết lập ngôn ngữ/khu vực của thiết bị
và tránh cảnh báo do thiếu `Locale`.

## 8. Cấu trúc dự án

Cấu trúc rút gọn:

``` text
A4/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/vn/edu/vhu/ltdd/a4events/
│       │   │   └── MainActivity.java
│       │   └── res/
│       │       ├── layout/
│       │       │   └── activity_main.xml
│       │       ├── values/
│       │       │   ├── strings.xml
│       │       │   ├── colors.xml
│       │       │   └── themes.xml
│       │       ├── values-night/
│       │       └── mipmap-*/
│       ├── test/
│       └── androidTest/
├── gradle/
│   └── libs.versions.toml
├── build.gradle.kts
├── settings.gradle.kts
├── gradlew
├── gradlew.bat
└── README.md
```

### Các file quan trọng

**`MainActivity.java`**

Chứa toàn bộ logic chính:

-   Ánh xạ View.
-   Listener cho các nút.
-   Bốn phép toán.
-   Xử lý `%` và `±`.
-   Kiểm tra dữ liệu và `try-catch`.
-   Tính và phân loại BMI.
-   Quản lý lịch sử 5 phép tính.
-   Lưu lịch sử bằng `onSaveInstanceState()`.

**`activity_main.xml`**

Định nghĩa giao diện trong `ScrollView`, gồm:

-   Tiêu đề và thông tin sinh viên.
-   Hai ô nhập số.
-   Sáu nút `+`, `−`, `±`, `×`, `÷`, `%`.
-   Dòng kết quả.
-   Vùng lịch sử.
-   Nút Xóa trắng.
-   Hai ô nhập BMI.
-   Nút Tính BMI.
-   Dòng BMI và phân loại.

**`strings.xml`**

Tập trung các chuỗi giao diện như tên ứng dụng, thông tin sinh viên,
nhãn phép toán, thông báo lỗi và các mức phân loại BMI.

## 9. Cài đặt và chạy ứng dụng

### 9.1. Yêu cầu

Máy cần có:

-   Android Studio.
-   Android SDK.
-   JDK tương thích với cấu hình Gradle của project.
-   Android Emulator hoặc thiết bị Android thật từ **API 24 trở lên**.
-   Git nếu muốn quản lý và đồng bộ mã nguồn.

### 9.2. Clone repository

``` bash
git clone https://github.com/HTham326/A3_241A010134.git
cd A4_241A010134
```

### 9.3. Mở project

1.  Mở **Android Studio**.
2.  Chọn **Open**.
3.  Chọn thư mục `A4_241A010134`.
4.  Chờ Gradle Sync hoàn tất.
5.  Chọn máy ảo hoặc thiết bị Android.
6.  Nhấn **Run**.

## 10. Hướng dẫn sử dụng

### Máy tính

1.  Nhập số thứ nhất vào ô **Số thứ nhất**.
2.  Nhập số thứ hai vào ô **Số thứ hai**.
3.  Nhấn `+`, `−`, `×` hoặc `÷`.
4.  Xem kết quả ở dòng **Kết quả**.
5.  Chọn một ô nhập rồi nhấn `±` để đảo dấu hoặc `%` để chuyển sang giá
    trị phần trăm.
6.  Xem các phép tính gần nhất trong phần **Lịch sử**.
7.  Nhấn **Xóa trắng** để làm sạch hai ô nhập và kết quả hiện tại.

### BMI

1.  Nhập cân nặng theo kilogram.
2.  Nhập chiều cao theo mét (`1.70`) hoặc centimet (`170`).
3.  Nhấn **Tính BMI**.
4.  Xem giá trị BMI và mức phân loại bên dưới.

## 11. Kiểm thử

Các nhóm trường hợp cần kiểm tra gồm:

    \# Dữ liệu / thao tác                Kết quả mong đợi
  ---- --------------------------------- --------------------------------
     1 Hai số hợp lệ + phép cộng         Tính đúng tổng
     2 Hai số hợp lệ + phép trừ          Tính đúng hiệu
     3 Hai số hợp lệ + phép nhân         Tính đúng tích
     4 Hai số hợp lệ + phép chia         Tính đúng thương
     5 Chia cho `0`                      Báo lỗi, không crash
     6 Bỏ trống một ô số                 `setError`, đưa focus về ô lỗi
     7 Dữ liệu không phải số             Hiển thị `Toast`, không crash
     8 BMI với chiều cao theo mét        Tính và phân loại đúng
     9 BMI với chiều cao theo centimet   Tự đổi cm → m rồi tính
    10 Cân nặng/chiều cao không hợp lệ   Báo lỗi, không crash

Với phần nâng cao cần kiểm tra thêm:

-   `±` đổi dấu đúng trên ô đang chọn.
-   `%` chia giá trị hiện tại cho `100`.
-   Lịch sử không vượt quá 5 phép tính.
-   Phép tính mới nhất nằm trên cùng.
-   Sau khi xoay màn hình, lịch sử vẫn được khôi phục.

## 12. Git và GitHub

Repository được đặt tên theo quy ước:

``` text
A4_241A010134
```

Các lệnh Git cơ bản:

``` bash
git status
git add .
git commit -m "A4: <noi-dung-commit>"
git push
```

Nên chia quá trình phát triển thành các commit có ý nghĩa, ví dụ:

``` text
A4: hoan thanh project co ban
A4: them phan tram va dao dau
A4: them lich su phep tinh
A4: them README
```

## 13. Kết quả hoàn thành

Project hiện triển khai:

-   [x] Giao diện bằng Java + XML.
-   [x] Hai ô nhập cho máy tính.
-   [x] Bốn phép toán cộng, trừ, nhân, chia.
-   [x] Kiểm tra dữ liệu rỗng.
-   [x] Bẫy lỗi `NumberFormatException`.
-   [x] Kiểm tra chia cho `0`.
-   [x] Báo lỗi bằng `setError()` và `Toast`.
-   [x] Định dạng kết quả với `String.format()` và `Locale`.
-   [x] Tính BMI.
-   [x] Chấp nhận chiều cao theo mét hoặc centimet.
-   [x] Phân loại BMI.
-   [x] **NC1:** phần trăm `%`.
-   [x] **NC1:** đảo dấu `±`.
-   [x] **NC2:** lưu tối đa 5 phép tính gần nhất.
-   [x] **NC2:** lưu lịch sử vào `Bundle` khi Activity bị tạo lại.
-   [x] Hiển thị thông tin sinh viên trong ứng dụng.
-   [x] Quản lý source code bằng Git/GitHub.

## 14. Kết luận

Lab A4 giúp thực hành toàn bộ luồng xử lý tương tác cơ bản của một ứng
dụng Android: từ **giao diện XML → ánh xạ View → bắt sự kiện → đọc dữ
liệu → kiểm tra → tính toán → xử lý lỗi → hiển thị kết quả**.

Thông qua máy tính và chức năng BMI, project củng cố việc sử dụng
`EditText`, `Button`, `TextView`, `View.OnClickListener`, `try-catch`,
`setError()`, `Toast`, `String.format()` và `Locale`. Hai bài nâng cao
tiếp tục mở rộng ứng dụng với thao tác `%`, `±`, cấu trúc
`ArrayList<String>` và cơ chế lưu trạng thái bằng
`Bundle`/`onSaveInstanceState()`.

------------------------------------------------------------------------

**Sinh viên thực hiện:** Nguyễn Thị Hồng Thắm\
**MSSV:** 241A010134\
**Học phần:** Lập trình trên các thiết bị di động -- INT4211
