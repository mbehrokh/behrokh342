package com.example.testpayani

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frm_1 = findViewById<FrameLayout>(R.id.ac_main_frm1)

        val edt_name = findViewById<EditText>(R.id.ac_main_edt_name)
        val edt_family = findViewById<EditText>(R.id.ac_main_edt_family)
        val edt_name_father = findViewById<EditText>(R.id.ac_main_edt_name_father)
        val edt_phone = findViewById<EditText>(R.id.ac_main_edt_phone1)
        val rqb_jenc = findViewById<RadioGroup>(R.id.ac_main_rgb_jens)

        val cb_quran = findViewById<CheckBox>(R.id.ac_main_cb_Quran)
        val cb_varzesh = findViewById<CheckBox>(R.id.ac_main_cb_varzesh)
        val cb_riazi = findViewById<CheckBox>(R.id.ac_main_cb_riazi)
        val cb_honar = findViewById<CheckBox>(R.id.ac_main_cb_Honar)

        val btn_confirm = findViewById<Button>(R.id.ac_main_btn_confirm)

        val sp_1 = arrayOf("انتخاب کنید", "حساب عادی", "حساب نقره ای", "حساب طلایی")
        val sp_2 = findViewById<Spinner>(R.id.ac_main_sp_account)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sp_1)
        sp_2.adapter = adapter


        //frm2

        val frm_2 = findViewById<FrameLayout>(R.id.ac_main_frm2)

        val tv_name = findViewById<TextView>(R.id.ac_main_tv_name)
        val tv_family = findViewById<TextView>(R.id.ac_main_tv_family)
        val tv_name_father = findViewById<TextView>(R.id.ac_main_tv_name_father)
        val tv_phone = findViewById<TextView>(R.id.ac_main_tv_phone)
        val tv_jens = findViewById<TextView>(R.id.ac_main_tv_jensiat)
        val tv_account = findViewById<TextView>(R.id.ac_main_tv_account)
        val tv_alaghe = findViewById<TextView>(R.id.ac_main_tv_alaghe)

        btn_confirm.setOnClickListener {

            if (edt_name.text.toString()=="" || edt_family.text.toString()=="" || edt_name_father.text.toString()=="" || edt_phone.text.toString()=="" ){
                Toast.makeText( this,"فیلد ها خالی میباشند", Toast.LENGTH_SHORT).show()

            }
            else if (!edt_phone.text.toString().startsWith("09")) {
                Toast.makeText(this, "از 09 شروع میشود", Toast.LENGTH_SHORT).show()
            }
            else if (edt_phone.text.toString().length != 11) {
                Toast.makeText(this, "شماره نامعتبر: شماره 11 رقمی میباشد", Toast.LENGTH_SHORT).show()
            }
            else if (rqb_jenc.checkedRadioButtonId == -1) {
                Toast.makeText(this, "جنسیت را انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if (sp_2.selectedItemPosition == 0) {
                Toast.makeText(this, "حساب کاربری خود را وارد کنید", Toast.LENGTH_SHORT).show()
            }
            else if (!cb_quran.isChecked && !cb_varzesh.isChecked && !cb_riazi.isChecked && !cb_honar.isChecked) {
                Toast.makeText(this, "گذینه مورد نظر را انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if (cb_quran.isChecked && cb_varzesh.isChecked && cb_riazi.isChecked && !cb_honar.isChecked) {
                Toast.makeText(this, "گذینه بیشتر از 2 نمیتوانید انتخاب کنید", Toast.LENGTH_SHORT).show()

            }
            else if (cb_quran.isChecked && cb_varzesh.isChecked && cb_riazi.isChecked) {
                Toast.makeText(this, "گذینه بیشتر از 2 نمیتوانید انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if (cb_quran.isChecked && cb_varzesh.isChecked && cb_honar.isChecked) {
                Toast.makeText(this, "گذینه بیشتر از 2 نمیتوانید انتخاب کنید", Toast.LENGTH_SHORT).show()
            }
            else if (cb_quran.isChecked && cb_riazi.isChecked && cb_honar.isChecked) {
                Toast.makeText(this, "گذینه بیشتر از 2 نمیتوانید انتخاب کنید", Toast.LENGTH_SHORT).show()

            }
            else if (cb_varzesh.isChecked && cb_riazi.isChecked && cb_honar.isChecked) {
                Toast.makeText(this, "گذینه بیشتر از 2 نمیتوانید انتخاب کنید", Toast.LENGTH_SHORT).show()
            }


            else {
                frm_1.visibility = View.GONE
                frm_2.visibility = View.VISIBLE

                tv_name.text = edt_name.text.toString()
                tv_family.text = edt_family.text.toString()
                tv_name_father.text = edt_name_father.text.toString()
                tv_phone.text = edt_phone.text.toString()

                val rb = findViewById<RadioButton>(rqb_jenc.checkedRadioButtonId)
                tv_jens.text = rb.text.toString()


                if (sp_2.selectedItemPosition == 1) {
                    tv_account.text = "نوع اکانت: عادی"
                }
                if (sp_2.selectedItemPosition == 2) {
                    tv_account.text = "نوع اکانت: نقره ای"
                }
                if (sp_2.selectedItemPosition == 3) {
                    tv_account.text = "نوع اکانت: طلایی"
                }

               if (cb_quran.isChecked){

                   tv_alaghe.text=cb_quran.text.toString()

               }
                if (cb_varzesh.isChecked){

                    tv_alaghe.text=cb_varzesh.text.toString()

                }
                if (cb_riazi.isChecked){

                    tv_alaghe.text=cb_riazi.text.toString()

                }
                if (cb_honar.isChecked){

                    tv_alaghe.text=cb_honar.text.toString()

                }
                if (cb_quran.isChecked && cb_varzesh.isChecked){

                    tv_alaghe.text=cb_quran.text.toString()+" , "+ cb_varzesh.text.toString()

                }
                if (cb_quran.isChecked && cb_riazi.isChecked){

                    tv_alaghe.text=cb_quran.text.toString()+" , "+ cb_riazi.text.toString()

                }
                if (cb_quran.isChecked && cb_honar.isChecked){

                    tv_alaghe.text=cb_quran.text.toString()+" , "+ cb_honar.text.toString()

                }
                if (cb_varzesh.isChecked && cb_riazi.isChecked){

                    tv_alaghe.text=cb_varzesh.text.toString()+" , "+cb_riazi.text.toString()

                }
                if (cb_riazi.isChecked && cb_honar.isChecked){

                    tv_alaghe.text=cb_riazi.text.toString()+", "+cb_honar.text.toString()

                }


            }


        }







    }


}











