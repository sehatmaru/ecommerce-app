package com.app.ecommerce.activity.base

import android.Manifest
import android.app.Dialog
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.TextView
import android.widget.Toast
import com.app.ecommerce.R

import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var progressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        progressDialog = Dialog(this)
        progressDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        progressDialog.setCanceledOnTouchOutside(false)
        progressDialog.setContentView(R.layout.dialog_loading)
    }

    fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun toast(messageId: Int) {
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
    }

    fun hasCallPhonePermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED
    }

    fun askCallPhonePermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CALL_PHONE),
                APP_PERMISSION_CALL_PHONE_REQUEST_CODE)
    }

    fun hasAccessContactPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED
    }

    fun askAccessContactPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_CONTACTS),
                APP_PERMISSION_CONTACT_REQUEST_CODE)
    }

    fun hasSendSMSPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED
    }

    fun askSendSMSPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.SEND_SMS),
                APP_PERMISSION_SEND_SMS_REQUEST_CODE)
    }

    fun hasCameraPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    fun askCameraPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA),
                APP_PERMISSION_CAMERA_REQUEST_CODE)
    }

    fun askReadPhoneState() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_PHONE_STATE),
                APP_PERMISSION_READ_PHONE_STATE)
    }

    fun hasReadPhoneState(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED
    }

    fun askCameraAndStoragePermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE),
                APP_PERMISSION_CAMERA_STORAGE_REQUEST_CODE)
    }

    fun askStoragePermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                APP_PERMISSION_READ_STORAGE_REQUEST_CODE)
    }

    fun hasAccessLocationPermission(): Boolean {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
    }

    fun askAccessLocationPermission() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                APP_PERMISSION_LOCATION_REQUEST_CODE)
    }

    fun hasStorageAccessPermission(): Boolean {
        val readStorageGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        val writeStorageGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || readStorageGranted || writeStorageGranted
    }

    fun hasCameraAndStorageAccessPermission(): Boolean {
        val writeStorageGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
        val cameraGranted = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M || writeStorageGranted && cameraGranted
    }

    @JvmOverloads
    protected fun configureToolbar(toolbarTitle: String, withBackArrow: Boolean, drawable: Drawable? = null) {
        val toolbar = getToolbar()
        if (toolbar != null) {
            setSupportActionBar(toolbar)

            if (this.supportActionBar == null) {
                throw RuntimeException("Unable to set support action bar")
            }

            if (withBackArrow) {
                toolbar.setNavigationOnClickListener { onBackPressed() }

                this.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)
            }

            this.supportActionBar!!.setHomeButtonEnabled(true)

            setToolbarTitle(toolbarTitle)

            if (drawable != null) {
                this.supportActionBar!!.setDisplayUseLogoEnabled(true)
                this.supportActionBar!!.setLogo(drawable)
            }

        }
    }

    private fun getToolbar(): Toolbar? {
        return this.findViewById(R.id.toolbar)
    }

    private fun setToolbarTitle(title: String) {
        if (supportActionBar != null) {
            supportActionBar!!.title = ""
        }
        getToolbar()?.setNavigationIcon(R.drawable.icon_back_active)
        if (getToolbar() != null) {
            val mTitle = getToolbar()!!.findViewById(R.id.toolbar_title) as TextView
            mTitle.text = title
        }
    }

    companion object {

        private val TAG = "BaseActivity"

        const val APP_PERMISSION_CALL_PHONE_REQUEST_CODE = 10
        const val APP_PERMISSION_CONTACT_REQUEST_CODE = 11
        const val APP_PERMISSION_SEND_SMS_REQUEST_CODE = 12
        const val APP_PERMISSION_CAMERA_REQUEST_CODE = 13
        const val APP_PERMISSION_READ_STORAGE_REQUEST_CODE = 14
        const val APP_PERMISSION_LOCATION_REQUEST_CODE = 15
        const val APP_PERMISSION_READ_PHONE_STATE = 16
        const val APP_PERMISSION_CAMERA_STORAGE_REQUEST_CODE = 17
    }

    fun showLoading(){
        progressDialog.show()
    }

    fun cancelLoading() {
        progressDialog.dismiss()
    }

}