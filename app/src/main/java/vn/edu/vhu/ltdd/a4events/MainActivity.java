package vn.edu.vhu.ltdd.a4events;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "A4_241A010134";
    private static final String KEY_LICH_SU = "lich_su";

    private EditText edtSoA, edtSoB, edtCanNang, edtChieuCao;
    private TextView tvKetQua, tvLichSu, tvBmi, tvPhanLoai;

    private char phepToanHienTai = '\0';

    ArrayList<String> lichSu = new ArrayList<>();

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        edtSoA = findViewById(R.id.edtSoA);
        edtSoB = findViewById(R.id.edtSoB);
        tvKetQua = findViewById(R.id.tvKetQua);
        tvLichSu = findViewById(R.id.tvLichSu);

        if(savedInstanceState != null) {
            ArrayList<String> lichSuDaLuu = savedInstanceState.getStringArrayList("KEY_LICH_SU");

            if(lichSuDaLuu != null) {
                lichSu = lichSuDaLuu;
                hienThiLichSu();
            }
        }

        edtCanNang = findViewById(R.id.edtCanNang);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        tvBmi = findViewById(R.id.tvBmi);
        tvPhanLoai = findViewById(R.id.tvPhanLoai);

        Button btnCong = findViewById(R.id.btnCong);
        Button btnTru = findViewById(R.id.btnTru);
        Button btnNhan = findViewById(R.id.btnNhan);
        Button btnChia = findViewById(R.id.btnChia);
        Button btnDaoDau = findViewById(R.id.btnDaoDau);
        Button btnPhanTram = findViewById(R.id.btnPhanTram);
        Button btnXoa = findViewById(R.id.btnXoa);
        Button btnTinhBmi = findViewById(R.id.btnTinhBmi);

        btnCong.setOnClickListener(v -> {
            phepToanHienTai = '+';
            tinhToan(phepToanHienTai);
        });
        btnTru.setOnClickListener(v -> {
            phepToanHienTai = '-';
            tinhToan(phepToanHienTai);
        });

        View.OnClickListener chung = v -> {
            int id = v.getId();
            if(id == R.id.btnNhan) {
                phepToanHienTai = '*';
                tinhToan(phepToanHienTai);
            } else if(id == R.id.btnChia) {
                phepToanHienTai = '/';
                tinhToan(phepToanHienTai);
            }
        };
        btnNhan.setOnClickListener(chung);
        btnChia.setOnClickListener(chung);

        btnDaoDau.setOnClickListener(v -> daoDau());
        btnPhanTram.setOnClickListener(v -> phanTram());
        btnXoa.setOnClickListener(v -> xoaTrang());
        btnTinhBmi.setOnClickListener(v -> tinhBmi());


    }

    private void daoDau() {
        EditText edtDangChon;

        if(edtSoA.hasFocus()) {
            edtDangChon = edtSoA;
        } else if(edtSoB.hasFocus()) {
            edtDangChon = edtSoB;
        } else {
            edtSoA.requestFocus();
            edtDangChon = edtSoA;
        }

        String chuoi = edtDangChon.getText().toString().trim();

        if(chuoi.isEmpty()) {
            edtDangChon.setError(getString(R.string.err_empty));
            edtDangChon.requestFocus();
            return;
        }

        try {
            double so = Double.parseDouble(chuoi);
            so = so * (-1);

            if(so == (long) so) {
                edtDangChon.setText(String.valueOf((long) so));
            } else {
                edtDangChon.setText(String.valueOf(so));
            }
            edtDangChon.setSelection(edtDangChon.getText().length());
        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.err_positive, Toast.LENGTH_SHORT).show();
        }
    }

    private void phanTram() {
        EditText edtDangChon;

        if(edtSoA.hasFocus()) {
            edtDangChon = edtSoA;
        } else if(edtSoB.hasFocus()) {
            edtDangChon = edtSoB;
        } else {
            edtSoA.requestFocus();
            edtDangChon = edtSoA;
        }

        String chuoi = edtDangChon.getText().toString().trim();

        if(chuoi.isEmpty()) {
            edtDangChon.setError(getString(R.string.err_empty));
            edtDangChon.requestFocus();
            return;
        }

        try {
            double so = Double.parseDouble(chuoi);
            so = so / 100.0;

            if(so == (long) so) {
                edtDangChon.setText(String.valueOf((long) so));
            } else {
                edtDangChon.setText(String.valueOf(so));
            }
            edtDangChon.setSelection(edtDangChon.getText().length());
        } catch (NumberFormatException e) {
            Toast.makeText(this, R.string.err_positive, Toast.LENGTH_SHORT).show();
        }
    }
    private void tinhToan(char phepToan) {
        String chuoiA = edtSoA.getText().toString().trim();
        String chuoiB = edtSoB.getText().toString().trim();

        if(chuoiA.isEmpty()) {
            edtSoA.setError(getString(R.string.err_empty));
            edtSoA.requestFocus();
            return;
        }
        if(chuoiB.isEmpty()) {
            edtSoB.setError(getString(R.string.err_empty));
            edtSoB.requestFocus();
            return;
        }

        double a, b;
        try {
            a = Double.parseDouble(chuoiA);
            b = Double.parseDouble(chuoiB);
        } catch (NumberFormatException e) {
            Log.e(TAG, "Dữ liệu nhập không phải số: '" + chuoiA + "', '" + chuoiB + "'", e);
            Toast.makeText(this, R.string.err_not_number, Toast.LENGTH_SHORT).show();
            return;
        }

        if(phepToan == '/' && b == 0) {
            edtSoB.setError(getString(R.string.err_divide_zero));
            Toast.makeText(this, R.string.err_divide_zero, Toast.LENGTH_SHORT).show();
            return;
        }

        double ketQua;
        switch (phepToan) {
            case '+': ketQua = a + b; break;
            case '-': ketQua = a - b; break;
            case '*': ketQua = a * b; break;
            default: ketQua = a / b; break;
        }

        String hienThiB;

        if(b < 0) {
            hienThiB = String.format(Locale.getDefault(), "(%.2f)", b);
        } else {
            hienThiB = String.format(Locale.getDefault(), "%.2f", b);
        }

        String phepTinh = String.format(Locale.getDefault(), "%.2f %c %s = %.2f",
                a, phepToan, hienThiB, ketQua
        );

        tvKetQua.setText(phepTinh);
        themLichSu(phepTinh);

        Log.d(TAG, "Phép tính: " + a + " " + phepToan + " " + b + " = " + ketQua);
    }

    private void themLichSu(String phepTinh){
        lichSu.add(0, phepTinh);

        if(lichSu.size() > 5) {
            lichSu.remove(lichSu.size() - 1);
        }

        hienThiLichSu();
    }

    private void hienThiLichSu() {
        StringBuilder noiDung = new StringBuilder();
        noiDung.append("Lịch sử:\n");

        for(String phepTinh : lichSu) {
            noiDung.append(phepTinh).append("\n");
        }

        tvLichSu.setText(noiDung.toString());
    }

    private void xoaTrang() {
        edtSoA.setText("");
        edtSoB.setText("");
        edtSoA.setError(null);
        edtSoB.setError(null);
        tvKetQua.setText(R.string.result_placeholder);
        edtSoA.requestFocus();
    }

    // ================ BMI ================
    private void tinhBmi() {
        try {
            double canNang = Double.parseDouble(edtCanNang.getText().toString().trim());
            double chieuCao = Double.parseDouble(edtChieuCao.getText().toString().trim());

            if(canNang <= 0 || chieuCao <= 0 ) {
                Toast.makeText(this, R.string.err_positive, Toast.LENGTH_SHORT).show();
                return;
            }

            if(chieuCao > 3) {
                chieuCao = chieuCao / 100.0;
            }

            double bmi = canNang / (chieuCao * chieuCao);
            tvBmi.setText(String.format(Locale.getDefault(), "BMI = %.1f", bmi));
            tvPhanLoai.setText(phanLoai (bmi));
        } catch (NumberFormatException e) {
            Log.e(TAG, "Lỗi nhập liệu BMI", e);
            Toast.makeText(this, R.string.err_not_number, Toast.LENGTH_SHORT).show();
        }
    }

    private String phanLoai(double bmi) {
        if(bmi < 18.5) return getString(R.string.bmi_under);
        if(bmi < 23) return getString(R.string.bmi_normal);
        if(bmi < 25) return getString(R.string.bmi_over);
        return getString(R.string.bmi_obese);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList(KEY_LICH_SU, lichSu);
    }
}