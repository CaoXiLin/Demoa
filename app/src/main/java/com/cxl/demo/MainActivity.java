package com.cxl.demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 用到的 控件
 * 1. drawerlayout  侧滑控件
 * 2.toolbar         标题栏
 * 3.navigationView 侧滑内容区域
 * 使用此类屏蔽 toolbar 左侧按钮的功能
 * ActionBarDrawerToggle
 *
 * 注意， toolbar  menu 中的  item  icon指定 图片在高版本中是不会显示的   也就是手机右角的图片 弹出的item
 *
 * 在低版本中可以 通过重写onPrepareOptionsPanel 方法 让他显示
 * 也有通过onMenuOpened 让 图片显示的，
 *
 * 但是在  android 7.0 中测试是不能显示的
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.navigationmenu)
    NavigationView navigationmenu;
    @BindView(R.id.drawerlayou)
    DrawerLayout mdrawerlayou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initNavigationmenu();

    }





    private void initNavigationmenu() {

        toolbar.inflateMenu(R.menu.menu_toolbar);   // 获取toolbar 右侧 按钮  如果不设置那么就不会显示 toolbar 右侧按钮

        View headerView = navigationmenu.getHeaderView(0);// 获取  头布局




        ImageView dengji = headerView.findViewById(R.id.dengji);  // 获取头布局的  控件id 设置 点击事件
        ImageView name = headerView.findViewById(R.id.name);
        TextView gexingqianm = headerView.findViewById(R.id.qianming);


        dengji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "等级", Toast.LENGTH_SHORT).show();
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "头像", Toast.LENGTH_SHORT).show();
            }
        });
        gexingqianm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "编辑个性签名", Toast.LENGTH_SHORT).show();
            }
        });

            //  获取 navigationmenu   Menu 事件
        navigationmenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.activate_vip:
                        Toast.makeText(MainActivity.this, "激活VIP", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.qq_money:
                        Toast.makeText(MainActivity.this, "QQ钱包", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dress_up:
                        Toast.makeText(MainActivity.this, "个性签名", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        // toolbar 获取 menu 点击事件，在获取此事件之前 必须先   toolbar.inflateMenu(R.menu.menu_toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sao:
                        Toast.makeText(MainActivity.this, "扫一扫", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.fukuan:
                        Toast.makeText(MainActivity.this, "付款", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.jia:
                        Toast.makeText(MainActivity.this, "加好友", Toast.LENGTH_SHORT).show();
                        break;
                }

                return false;
            }
        });


        //  设置 toolbar 默认图标
        toolbar.setNavigationIcon(R.mipmap.apple);


        // 设置toolbar 点击图标 打开drawerlayout 侧滑菜单
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mdrawerlayou.openDrawer(GravityCompat.START);
            }
        });


        //禁掉 toolbare 左侧按钮的 事件
        ActionBarDrawerToggle actionBarDrawerToggle = new
                ActionBarDrawerToggle(MainActivity.this, mdrawerlayou, R.string.open, R.string.close);
        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.setDrawerIndicatorEnabled(false);

        mdrawerlayou.addDrawerListener(actionBarDrawerToggle);



//
//        // 使用默认  ActionBarDrawerToggle  也可以 和 TOOlbar 关联起来
//        ActionBarDrawerToggle actionBarDrawerToggle1 = new                  // 这个参数就要加个  toolbar然后就
//                ActionBarDrawerToggle(MainActivity.this, mdrawerlayou,toolbar, R.string.open, R.string.close);
//        actionBarDrawerToggle.syncState();  // 同步
//
//        mdrawerlayou.addDrawerListener(actionBarDrawerToggle);
//


    }


}




