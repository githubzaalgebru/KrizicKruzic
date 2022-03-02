package com.algebra.krizickruzic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity( ) {

    private var igra : Igra? = Igra( )
    private val b            = arrayOfNulls< ImageView >( 9 )


    override fun onCreate( savedInstanceState: Bundle? ) {
        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_main )

        initWidgets( )
    }

    private fun initWidgets( ) {
        b[0] = findViewById( R.id.imageView0 )
        b[1] = findViewById( R.id.imageView1 )
        b[2] = findViewById( R.id.imageView2 )
        b[3] = findViewById( R.id.imageView3 )
        b[4] = findViewById( R.id.imageView4 )
        b[5] = findViewById( R.id.imageView5 )
        b[6] = findViewById( R.id.imageView6 )
        b[7] = findViewById( R.id.imageView7 )
        b[8] = findViewById( R.id.imageView8 )
    }

    fun igraj( v : View ) {
        val tag = ( v as ImageView ).tag.toString( ).toInt( )
        if( igra!!.igraj( tag ) ) {
            v.setImageResource( R.drawable.krizic )
            val potezRacunala = nadjiPotez( )
            if( potezRacunala!=-1 ) {
                if( igra!!.igraj( potezRacunala, false ) ) {
                    b[potezRacunala]!!.setImageResource( R.drawable.kruzic )
                }
            }
        }
    }

    fun nadjiPotez( ) : Int {
        val odigrano = igra!!.zauzetaPolja( )
        for( i in 0..8 )
            if( !odigrano.contains( i ) )
                return i
        return -1
    }
}