package uk.co.massimocarli.spinneractionviewtest

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

  /*
 * The Tag for the Log
 */
  private val TAG_LOG = "MainActivity"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    // We get the reference to the Spinner to manage it's events
    val spinnerMenuItem = menu.findItem(R.id.menu_spinner)
    val spinner = spinnerMenuItem.actionView
      .findViewById(R.id.menu_spinner) as Spinner
    spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

      override fun onItemSelected(
        spinner: AdapterView<*>, view: View,
        position: Int, id: Long
      ) {
        Log.i(TAG_LOG, "In Spinner selected item ${spinner.getItemAtPosition(position)}")
      }

      override fun onNothingSelected(spinner: AdapterView<*>) {
        Log.i(TAG_LOG, "Nothing selected in Spinner")
      }
    }
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    Log.i(TAG_LOG, "Selected item ${item.title}")
    return super.onOptionsItemSelected(item)
  }
}
