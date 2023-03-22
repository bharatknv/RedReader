package org.quantumbadger.redreader.common;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

import java.util.Observable;

public class ObservableSSB {
	private final SpannableStringBuilder ssb;
	private final Observable observable;

	public ObservableSSB() {
		this.ssb = new SpannableStringBuilder();
		this.observable = new Observable();
	}

	public void append(CharSequence text) {
		this.ssb.append(text);
		this.observable.notifyObservers();
	}

	public void append(CharSequence text, int start, int end) {
		this.ssb.append(text, start, end);
		this.observable.notifyObservers();
	}

	public SpannableStringBuilder getSsb() {
		return this.ssb;
	}

	public Observable getObservable() {
		return this.observable;
	}

	public void replace(CharSequence text, Object what) {
		final int textStartIndex = TextUtils.indexOf(ssb, text);
		this.ssb.setSpan(what, textStartIndex, textStartIndex + text.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
		this.observable.notifyObservers();
	}

	public boolean isEmpty() {
		return this.ssb.length() > 0;
	}
}
