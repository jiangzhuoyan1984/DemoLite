package com.lin.jiang.app.material;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.lin.jiang.app.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialActivity extends AppCompatActivity {

    @BindView(R.id.tb_tool_bar)
    Toolbar mTbToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);
        ButterKnife.bind(this);

        /*=========================================================================
         * 现在不推荐使用 ActionBar，推荐使用 ToolBar；使用 ToolBar 之前需要禁用 ActionBar，
         * 禁用 ActionBar 方法：
         * 方法一：AndroidManifest.xml 文件中将 Activity 配置为 NoActionBar；
         * 方法二：使用 Java 代码隐藏 ActionBar，代码如下
         * ActionBar actionBar = getSupportActionBar();
         * if (actionBar != null) {
         *    actionBar.hide();
         * }
         *========================================================================*/

        setSupportActionBar(mTbToolBar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*=========================================================================
         * ToolBar 中的 action 只会显示图标，menu 中的 action 只会显示文字。
         *========================================================================*/
        getMenuInflater().inflate(R.menu.menu_material_tool_bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(this, "Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
