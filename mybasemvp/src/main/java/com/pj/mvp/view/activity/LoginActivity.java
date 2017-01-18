package com.pj.mvp.view.activity;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.pj.mvp.R;
import com.pj.mvp.contract.LoginContract;
import com.pj.mvp.persenter.LoginPresenter;
import com.pj.mvp.view.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 登录
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {

    @BindView(R.id.email)
    AutoCompleteTextView email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.email_sign_in_button)
    Button emailSignInButton;
    private LoginPresenter mPresenter;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mPresenter = new LoginPresenter();
        mPresenter.attachView(this);
    }

    @OnClick(R.id.email_sign_in_button)
    public void onClick(View v) {
        mPresenter.login(email.getText().toString().trim(), password.getText().toString().trim());
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onNameError() {
        email.setError("用户名错误");
    }

    @Override
    public void onPassWordError() {
        password.setError("密码错误");
    }

    @Override
    public void showError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void complete() {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
