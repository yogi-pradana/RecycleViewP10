package com.p3b1yogi.recycleviewp10

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import com.p3b1yogi.recycleviewp10.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup Toolbar
        setupToolbar()

        // Prepare movie data
        val movieList = prepareMovieData()

        // Setup RecyclerView with Adapter
        setupRecyclerView(movieList)
    }

    private fun setupToolbar() {
        val toolbar: Toolbar = binding.toolbar // Gunakan binding untuk akses toolbar
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    private fun prepareMovieData(): List<Movie> {
        return listOf(
            Movie(
                title = "Venom : The Last Dance",
                genre = "Action",
                duration = "1h 44m",
                rating = "R",
                synopsis = "Eddie Brock, seorang jurnalis yang berjuang dengan kehidupannya setelah insiden yang menghancurkan karirnya, menemukan dirinya terjerat dalam pertarungan melawan Carlton Drake, pendiri Life Foundation yang terkenal dan cerdik. Setelah berhasil mengikat diri dengan makhluk alien bernama Venom, Eddie mendapatkan kekuatan luar biasa yang memungkinkannya untuk melawan ketidakadilan dan menyelamatkan nyawa.",
                imageResId = R.drawable.venom
            ),
            Movie(
                title = "DOSA MUSYRIK",
                genre = "Horror",
                duration = "1h 32m",
                rating = "D17+",
                synopsis = "Dalam film horror yang menegangkan ini, kita dibawa ke sebuah desa terpencil di mana kepercayaan dan tradisi lokal telah bertahan selama berabad-abad. Ketika sekelompok pemuda dari kota berkunjung untuk berlibur, mereka tidak menyadari bahwa mereka telah mengganggu roh-roh yang selama ini dihormati oleh penduduk desa. Dosa musyrik yang mereka lakukan mengundang malapetaka dan membawa konsekuensi yang mengerikan. Dengan setiap langkah yang mereka ambil, ketegangan meningkat saat karakter-karakter ini dihadapkan pada kejahatan yang tidak mereka mengerti. Ketika satu per satu dari mereka mulai mengalami kejadian-kejadian supernatural yang menakutkan, mereka harus mencari cara untuk membebaskan diri dari kutukan yang telah mereka picu. Dalam perjalanan ini, mereka tidak hanya berjuang untuk bertahan hidup, tetapi juga menghadapi dosa-dosa masa lalu yang kembali menghantui mereka. Akankah mereka bisa menemukan jalan keluar sebelum semuanya terlambat, atau akankah mereka terjebak dalam kegelapan selamanya?",
                imageResId = R.drawable.dosa_musrik
            ),
            Movie(
                title = "Inside Out 2",
                genre = "Animation",
                duration = "1h 32m",
                rating = "SU",
                synopsis = "Kembalinya Riley dalam petualangan emosional yang baru di \"Inside Out 2\" menandai perubahan besar dalam hidupnya. Sekarang remaja, Riley harus menghadapi tantangan baru yang datang seiring dengan pertumbuhan dan perubahannya. Ketika emosi yang lebih kompleks mulai muncul, seperti rasa malu dan kecemasan, para emosi yang sudah dikenal - Joy, Sadness, Anger, Fear, dan Disgust - harus bekerja sama untuk membimbing Riley melalui masa-masa sulit ini. Dalam perjalanan yang menakjubkan, mereka menjelajahi berbagai aspek baru dari pikiran Riley, termasuk perubahan dalam persahabatan dan hubungan dengan keluarganya. Di tengah kekacauan yang disebabkan oleh perasaan baru ini, Joy harus belajar bahwa kadang-kadang, kesedihan juga memiliki perannya yang penting dalam membantu Riley menemukan kebahagiaan sejati. Dengan humor yang cerdas dan pesan yang menyentuh hati, film ini mengingatkan kita tentang pentingnya menerima semua emosi kita, tidak peduli seberapa rumitnya.",
                imageResId = R.drawable.inside_out
            ),
            Movie(
                title = "Transformer One",
                genre = "Action",
                duration = "1h 46m",
                rating = "R13+",
                synopsis = "Dalam \"Transformer One,\" para Autobots dan Decepticons kembali dengan konflik yang lebih besar daripada sebelumnya. Dengan latar belakang planet yang terancam punah, Optimus Prime dan timnya harus menemukan cara untuk menghentikan Megatron dan pasukannya yang berniat menguasai Bumi dan menjadikannya basis untuk serangan mereka yang lebih besar. Dalam film ini, kita melihat sejarah asal-usul para robot raksasa ini, menjelajahi bagaimana mereka terbentuk dan perjuangan mereka melawan kekuatan jahat yang mengancam kehidupan di alam semesta. Ketika pertempuran epik dimulai, kedua sisi harus mempertanyakan ideologi dan tujuan mereka, serta bertanya pada diri sendiri: Apa yang sebenarnya mereka perjuangkan? Dengan efek visual yang memukau dan aksi yang tak terduga, \"Transformer One\" membawa penonton dalam perjalanan mendebarkan yang menjelajahi tema persahabatan, pengorbanan, dan keberanian dalam menghadapi kejahatan.",
                imageResId = R.drawable.transformer_one
            )
        )
    }

    private fun setupRecyclerView(movieList: List<Movie>) {
        val adapter = MovieAdapter(this, movieList)
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2) // Menggunakan GridLayoutManager
        binding.recyclerView.adapter = adapter
    }
}
