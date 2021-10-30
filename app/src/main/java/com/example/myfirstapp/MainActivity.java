package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spcategory,spitemname;
    ArrayAdapter<String> itemAdapter;
    ArrayAdapter<String> categoryAdapter;
    String category="请选择学院", item="请选择班级";
    String[] categorylist=new String[] {"请选择种类","蔬菜","水果","饮料","奶制品","肉类","冷冻食品"};
    String[] shucai=new String[] {"请选择蔬菜","白菜","韭菜","油菜","菠菜","大葱","生姜","大蒜","大头菜","茄子","其他"};
    String[] shuiguo=new String[] {"请选择水果","苹果","葡萄","猕猴桃","桃","香蕉","洋梨","幸水梨","柿子","西瓜","哈密瓜","其他"};
    String[] yinliao=new String[] {"请选择饮料","茶","咖啡","果汁","豆乳","其他"};
    String[] naizhipin=new String[] {"请选择奶制品","牛奶","固体酸奶","液体酸奶","芝士","牛油","其他"};
    String[] roulei=new String[] {"请选择肉类","猪肉","牛肉","羊肉","鸡肉","其他"};
    String[] lengdong=new String[] {"请选择冷冻食品","鸡肉块","意面","便当制作包","干豆腐","其他"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spcategory= findViewById(R.id.spinner1);
        spitemname= findViewById(R.id.spinner2);
        setSpinner();

        Button saveDataMain = findViewById(R.id.saveDataMain);
        saveDataMain.setOnClickListener(v -> openDisplayMessageActivity());

        Button itemList = findViewById(R.id.itemListMain);
        itemList.setOnClickListener(v -> openItemListActivity());
    }

    public void setSpinner(){
        //绑定适配器和值
        categoryAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorylist);
        spcategory.setAdapter(categoryAdapter);
        spcategory.setSelection(0,true); //设置初始默认值
        //绑定适配器和值
        itemAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shucai);
        spitemname.setAdapter(itemAdapter);
        spitemname.setSelection(0,true); //设置初始默认值

        //设置列表项选中监听
        spcategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                //获取选中项的值
                category=adapterView.getItemAtPosition(i).toString();
                //根据选中的不同的值绑定不同的适配器
                if(category.equals("蔬菜")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, shucai);
                    spitemname.setAdapter(itemAdapter);
                }else if(category.equals("水果")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, shuiguo);
                    spitemname.setAdapter(itemAdapter);
                }else if(category.equals("饮料")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, yinliao);
                    spitemname.setAdapter(itemAdapter);
                }else if(category.equals("奶制品")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, naizhipin);
                    spitemname.setAdapter(itemAdapter);
                }else if(category.equals("肉类")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, roulei);
                    spitemname.setAdapter(itemAdapter);
                }else if(category.equals("冷冻食品")){
                    itemAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item, lengdong);
                    spitemname.setAdapter(itemAdapter);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });

        //设置列表项选中监听
        spitemname.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){
                //获取列表项的值
                item=adapterView.getItemAtPosition(i).toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView){
            }
        });

    }

    /** Called when the user taps the Send button */
    public void openDisplayMessageActivity() {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        String message1 = spinner1.getSelectedItem().toString();
        String message2 = spinner2.getSelectedItem().toString();
        String message3 = spinner3.getSelectedItem().toString();
        String message4 = editText1.getText().toString();
        String message5 = editText2.getText().toString();
        String message6 = editText3.getText().toString();
        intent.putExtra("message1", message1);
        intent.putExtra("message2", message2);
        intent.putExtra("message3", message3);
        intent.putExtra("message4", message4);
        intent.putExtra("message5", message5);
        intent.putExtra("message6", message6);
        startActivity(intent);
    }

    public void openItemListActivity() {
        Intent intent = new Intent(this, ItemListActivity.class);
        startActivity(intent);
    }
}

