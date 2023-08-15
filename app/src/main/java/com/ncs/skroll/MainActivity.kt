package com.ncs.skroll

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.ncs.skroll.ui.theme.SKrollTheme
import com.ncs.skroll.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        lifecycleScope.launchWhenCreated {
            setContent {
                Column() {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        ProgressBar()
                        Box(Modifier.padding(top = 80.dp)) {
                            Text(text = "Hold On! fetching the data")
                        }
                    }
                }
            }
            delay(3000L)
            if (mainViewModel.items != null) {
                setContent {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(1f), contentAlignment = Alignment.Center
                    ) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(1f)
                                    .padding(top = 25.dp), contentAlignment = Alignment.Center
                            ) {

                            }
                            Spacer(modifier = Modifier.height(30.dp))
                            LazyColumn{
                                items(1) {
                                    resbanner(items = mainViewModel.items!!)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun ProgressBar() {
    CircularProgressIndicator(
        modifier = Modifier.padding(16.dp),
        color = Color.Blue,
        strokeWidth = Dp(value = 4F)
    )
}


