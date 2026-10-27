package com.rohitgalthariya.aistudio

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.ViewGroup
import android.widget.*

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val scroll = ScrollView(this)
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 28, 24, 28)
            setBackgroundColor(Color.rgb(247, 245, 252))
        }
        scroll.addView(root)
        val title = TextView(this).apply {
            text = "Rohit Galthariya AI Studio"
            textSize = 25f; setTextColor(Color.rgb(51,37,107)); gravity = Gravity.CENTER
        }
        root.addView(title, matchWrap())
        addText(root, "તમારો પર્સનલ AI સહાયક", 16f, true)
        addText(root, "લેખન • કહાની • અભ્યાસ • વિચાર", 14f, false)

        val language = Spinner(this)
        language.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, listOf("ગુજરાતી", "हिन्दी", "English"))
        root.addView(language, matchWrap())

        addText(root, "તમારો પ્રશ્ન અથવા કહાની લખો:", 16f, true)
        val input = EditText(this).apply {
            hint = "અહીં લખો..."
            minLines = 5; gravity = Gravity.TOP
            setPadding(14, 14, 14, 14)
            setBackgroundColor(Color.WHITE)
        }
        root.addView(input, matchWrap())
        val result = TextView(this).apply { textSize = 16f; setTextColor(Color.DKGRAY); setPadding(0, 18, 0, 18) }
        val button = Button(this).apply {
            text = "લખાણ તૈયાર કરો"
            setOnClickListener {
                val text = input.text.toString().trim()
                result.text = if (text.isEmpty()) "કૃપા કરીને પહેલાં કંઈક લખો." else "તમારું લખાણ મળ્યું છે.\n\nઆ પ્રારંભિક આવૃત્તિ છે; AI જવાબ અને વીડિયો બનાવવા માટે ઓનલાઇન AI સેવા/API જોડવાની બાકી છે.\n\nતમારું લખાણ:\n$text"
            }
        }
        root.addView(button, matchWrap())
        root.addView(result, matchWrap())
        val video = Button(this).apply {
            text = "AI વીડિયો બનાવો (સેવા જોડવાની બાકી)"
            setOnClickListener { result.text = "AI વીડિયો બનાવવા માટે વીડિયો જનરેશન સેવા અને API કનેક્શન જરૂરી છે. આ આવૃત્તિ હજી વીડિયો જનરેટ કરતી નથી." }
        }
        root.addView(video, matchWrap())
        setContentView(scroll)
    }

    private fun matchWrap() = LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply { bottomMargin = 14 }
    private fun addText(root: LinearLayout, value: String, size: Float, bold: Boolean) {
        root.addView(TextView(this).apply { text = value; textSize = size; setTextColor(Color.rgb(45,42,55)); if (bold) setTypeface(null, android.graphics.Typeface.BOLD); setPadding(0, 10, 0, 10) }, matchWrap())
    }
}
