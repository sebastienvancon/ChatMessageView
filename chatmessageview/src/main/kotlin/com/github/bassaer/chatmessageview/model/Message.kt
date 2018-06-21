package com.github.bassaer.chatmessageview.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import com.github.bassaer.chatmessageview.util.*
import java.util.*

/**
 * Message object
 * Created by nakayama on 2016/08/08.
 */
class Message {

    /**
     * Sender information
     */
    lateinit var user: IChatUser

    /**
     * Drawable for the background of the message
     */
    var mBackground : Drawable? = null

    /**
     * Color of the background of the message
     */
    var mColorBackground: Int = 0

    /**
     * TextColor of the background
     */
    var mColorText: Int = 0

    /**
     * Url For the Poi Icon
     */
    var mUrlIcon : String = ""

    /**
     * Id of a Contact
     */
    var mId : String = ""

    /**
     * Temperature maximum for the weather message
     */
    var mTempMax : Int? = null

    /**
     * Temperature minimum for the weather message
     */
    var mTempMin : Int? = null

    /**
     * Trending of the weather
     */
    var mTrend : String? = null

    /**
     * Day of the weather
     */
    var mDay : String? = null

    /**
     * Resource for the weather background
     */
    var mResourceBack : Int = 0

    /**
     * Id of an icon for the weather
     */
    var mWeatherIcon : Int = 0

    /**
     * Whether sender username is shown or not
     */
    var usernameVisibility = true
    /**
     * If true, there is the icon space but invisible.
     */
    var iconVisibility = true
    /**
     * If true, there is no icon space.
     */
    var isIconHided = false
        private set

    /**
     * Whether the message is shown right side or not.
     */
    var isRight: Boolean = false

    /**
     * Message content text
     */
    var text: String? = null

    /**
     * The time message that was created
     */
    var sendTime = Calendar.getInstance()

    /**
     * Whether cell of list view is date separator text or not.
     */
    var isDateCell: Boolean = false

    /**
     * TEXT format of the send time that is next to the message
     */
    private var mSendTimeFormatter: ITimeFormatter? = null

    /**
     * Date separator text format.
     * This text is shown if the before or after message was sent different day
     */
    private var mDateFormatter: ITimeFormatter? = null

    /**
     * Message status
     * You can use to know the message status such as fail, delivered, seen.. etc.
     */
    var status: Int = 0

    /**
     * Message status type such as icon, text, or none.
     */
    var statusStyle = STATUS_NONE

    /**
     * Message status icon formatter
     */
    var statusIconFormatter: IMessageStatusIconFormatter? = null

    /**
     *  Status Colorizer Enabled
     *  Can be used to disable the status icon colorizer so status icon keeps original color.
     *  Use when updating status icon to another drawable and you don't want it's color to be altered
     */
    var statusColorizeEnabled: Boolean = true

    /**
     * Message status text formatter
     */
    var statusTextFormatter: IMessageStatusTextFormatter? = null

    /**
     * PICTURE message
     */
    var picture: Bitmap? = null
    /**
     * Message type
     */
    var type: Type? = null

    val timeText: String
        get() = mSendTimeFormatter!!.getFormattedTimeText(sendTime!!)

    val dateSeparateText: String
        get() = mDateFormatter!!.getFormattedTimeText(sendTime!!)

    val statusIcon: Drawable
        get() = statusIconFormatter!!.getStatusIcon(status, isRight)

    val statusText: String
        get() = statusTextFormatter!!.getStatusText(status, isRight)

    /**
     * Message Types
     *
     */
    enum class Type {
        TEXT,
        PICTURE,
        MAP,
        LINK,
        CONTACT,
        POI,
        TRAFFIC,
        WEATHER,
        DOTS
    }

    /**
     * Constructor
     */
    init {
        sendTime = Calendar.getInstance()
        mSendTimeFormatter = DefaultTimeFormatter()
        mDateFormatter = DateFormatter()
        mSendTimeFormatter = DefaultTimeFormatter()
        type = Type.TEXT
    }

    /**
     * Message builder
     */
    class Builder {
        private val message: Message = Message()

        fun setUser(user: IChatUser): Builder {
            message.user = user
            return this
        }

        fun setUsernameVisibility(visibility: Boolean): Builder {
            message.usernameVisibility = visibility
            return this
        }

        fun setUserIconVisibility(visibility: Boolean): Builder {
            message.iconVisibility = visibility
            return this
        }

        fun hideIcon(hide: Boolean): Builder {
            message.hideIcon(hide)
            return this
        }


        fun setRight(isRight: Boolean): Builder {
            message.isRight = isRight
            return this
        }

        fun setText(text: String): Builder {
            message.text = text
            return this
        }

        fun setSendTime(calendar: Calendar): Builder {
            message.sendTime = calendar
            return this
        }

        fun setDateCell(isDateCell: Boolean): Builder {
            message.isDateCell = isDateCell
            return this
        }

        fun setSendTimeFormatter(sendTimeFormatter: ITimeFormatter): Builder {
            message.setSendTimeFormatter(sendTimeFormatter)
            return this
        }

        fun setDateFormatter(dateFormatter: ITimeFormatter): Builder {
            message.setDateFormatter(dateFormatter)
            return this
        }

        fun setStatus(status: Int): Builder {
            message.status = status
            return this
        }

        fun setStatusStyle(statusStyle: Int): Builder {
            message.statusStyle = statusStyle
            return this
        }

        fun setStatusIconFormatter(formatter: IMessageStatusIconFormatter): Builder {
            message.statusIconFormatter = formatter
            return this
        }

        fun setStatusTextFormatter(formatter: IMessageStatusTextFormatter): Builder {
            message.statusTextFormatter = formatter
            return this
        }

        fun setType(type: Type): Builder {
            message.type = type
            return this
        }

        fun setPicture(picture: Bitmap): Builder {
            message.picture = picture
            return this
        }
        fun setBackgroundColor(color : Int): Builder{
            message.mColorBackground = color
            return this
        }

        fun setTextColor(color : Int):Builder{
            message.mColorText = color
            return this
        }

        fun setTrend(trend : String):Builder{
            message.mTrend = trend
            return this
        }

        fun setTempMax(temp : Int):Builder{
            message.mTempMax = temp
            return this
        }

        fun setTempMin(temp : Int):Builder{
            message.mTempMin = temp
            return this
        }

        fun setDay(day : String):Builder{
            message.mDay = day
            return this
        }

        fun setUrlIcon(url : String):Builder{
            message.mUrlIcon = url
            return this
        }

        fun setId(id : String): Builder{
            message.mId = id
            return this
        }

        fun build(): Message {
            return message
        }
    }

    fun hideIcon(hideIcon: Boolean) {
        isIconHided = hideIcon
    }

    /**
     * Set custom send time text formatter
     * @param sendTimeFormatter custom send time formatter
     */
    fun setSendTimeFormatter(sendTimeFormatter: ITimeFormatter) {
        mSendTimeFormatter = sendTimeFormatter
    }

    /**
     * Set custom date text formatter
     * @param dateFormatter custom date formatter
     */
    fun setDateFormatter(dateFormatter: ITimeFormatter) {
        mDateFormatter = dateFormatter
    }

    fun setBackgroundColor(color : Int){
        mColorBackground = color
    }

    fun setBackground(color : Drawable){
        mBackground = color
    }

    fun setBackgroundResources(res : Int){
        mResourceBack = res
    }

    fun setWeatherIcon(res : Int){
        mWeatherIcon = res
    }

    fun setTextColor(color : Int){
        mColorText = color
    }

    fun getTextColor() : Int{
        return mColorText
    }

    fun getBackgroundColor() : Int{
        return mColorBackground
    }

    fun getBackground() : Drawable?{
        return mBackground
    }

    fun getBackgroundResource() : Int{
        return mResourceBack
    }

    fun getWeatherIcon() : Int{
        return mWeatherIcon
    }

    fun getUrl(): String{
        return mUrlIcon
    }

    fun getId(): String{
        return mId
    }

    fun getTrend(): String?{
        return mTrend
    }

    fun getTempMax() : Int?{
        return mTempMax
    }

    fun getTempMin(): Int?{
        return mTempMin
    }

    fun getDay() : String?{
        return mDay
    }

    interface OnBubbleClickListener {
        fun onClick(message: Message)
    }

    interface OnBubbleLongClickListener {
        fun onLongClick(message: Message)
    }

    interface OnIconClickListener {
        fun onIconClick(message: Message)
    }

    interface OnIconLongClickListener {
        fun onIconLongClick(message: Message)
    }

    companion object {

        /**
         * Message status is not shown.
         */
        val STATUS_NONE = 0

        /**
         * Show message status icon.
         */
        val STATUS_ICON = 1

        /**
         * Show message status text.
         * ex. seen, fail, delivered
         */
        val STATUS_TEXT = 2

        /**
         * Show message status icon only right message
         */
        val STATUS_ICON_RIGHT_ONLY = 3

        /**
         * Show message status icon only left message
         */
        val STATUS_ICON_LEFT_ONLY = 4

        /**
         * Show message status text only right message
         */
        val STATUS_TEXT_RIGHT_ONLY = 5

        /**
         * Show message status text only left message
         */
        val STATUS_TEXT_LEFT_ONLY = 6
    }
}
