package com.skinrun.beabox.h5;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class SkinRunH5MainActivity extends Activity {
	WebView webView;
	ProgressBar loading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_skin_run_h5_main);

		webView = (WebView) findViewById(R.id.webView);
		loading = (ProgressBar) findViewById(R.id.loading);

		// webView.setVerticalScrollBarEnabled(false);
		// webView.setHorizontalScrollBarEnabled(false);

		WebSettings settings = webView.getSettings();
		// ������ҳ�Ϳɼ���JavaScript��
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setBuiltInZoomControls(false);// ��ʾ�Ŵ���С��ť
		settings.setSupportZoom(false);// ����Ŵ���С

		// settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
				loading.setVisibility(View.VISIBLE);
			}

			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				loading.setVisibility(View.GONE);
			}

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				super.onReceivedError(view, errorCode, description, failingUrl);
				loading.setVisibility(View.GONE);
			}
		});

		// settings.setUseWideViewPort(true);
		// settings.setLoadWithOverviewMode(true);

		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		int mDensity = metrics.densityDpi;
		Log.d("maomao", "densityDpi = " + mDensity);
		if (mDensity == 240) {
			settings.setDefaultZoom(ZoomDensity.FAR);
		} else if (mDensity == 160) {
			settings.setDefaultZoom(ZoomDensity.MEDIUM);
		} else if (mDensity == 120) {
			settings.setDefaultZoom(ZoomDensity.CLOSE);
		} else if (mDensity == DisplayMetrics.DENSITY_XHIGH) {
			settings.setDefaultZoom(ZoomDensity.FAR);
		} else if (mDensity == DisplayMetrics.DENSITY_TV) {
			settings.setDefaultZoom(ZoomDensity.FAR);
		} else {
			settings.setDefaultZoom(ZoomDensity.MEDIUM);
		}

		// http://skinrun.renzhi.net/merchant/index/login.html
		// http://merchant.skinrun.me

		/**
		 * ��WebView��ʾͼƬ����ʹ��������� ������ҳ�������ͣ� 1��LayoutAlgorithm.NARROW_COLUMNS ��
		 * ��Ӧ���ݴ�С 2��LayoutAlgorithm.SINGLE_COLUMN:��Ӧ��Ļ�����ݽ��Զ�����
		 */
//		settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
//		settings.setUseWideViewPort(true);
		
		 settings.setLoadWithOverviewMode(true);
		 settings.setUseWideViewPort(true);

		webView.requestFocusFromTouch();
//		webView.loadUrl("http://merchant.skinrun.me");
		webView.loadUrl("http://b.skinrun.me");
//		String string = "<p style=\"text-align: left; white-space: normal;\"><strong style=\"color: rgb(0, 0, 0); font-family: ����; line-height: 1.5;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150510/90501431271721571.jpg\" _src=\"http://a.skinrun.cn/jsp/upload/20150510/90501431271721571.jpg\"/></strong></p><p style=\"text-align: left; white-space: normal;\"><strong style=\"color: rgb(0, 0, 0); font-family: ����; line-height: 1.5;\">ÿ���˶����Լ��Ļ���ʱ��������ϻ������ϣ�ͨ�����Ǽ����ӻ����أ���������Щ����Ʒ�أ�����Խ�м�ֵԽ�л����Ŷ��</strong></p><p style=\"white-space: normal;\"><span style=\"color: rgb(0, 0, 0); font-family: ����; font-weight: bold;\"><br/></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; font-family: ����; background-color: rgb(255, 0, 0);\"></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 18px;\"><span style=\"font-weight: bold; font-family: ����;\"><span style=\"color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\">���ڽ�Ʒ</span>��</span></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 18px;\"><span style=\"font-weight: bold; font-family: ����;\">JACQUES&nbsp;ANDHREL��Ч�����Ĥ</span><span style=\"font-weight: bold; font-family: ����;\">&nbsp;</span></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 14px; font-family: &#39;Times New Roman&#39;;\"></span></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/66261430818315422.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/66261430818315422.png\"/></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/93111430818324874.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/93111430818324874.png\"/><span style=\"font-family: ����; font-weight: bold; line-height: 1.5; text-align: -webkit-center; font-size: 18px; color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\">��Ч��</span><span style=\"text-align: -webkit-center; line-height: 1.5; font-size: 14px; font-family: &#39;Times New Roman&#39;;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/17181430816361309.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/17181430816361309.png\" style=\"width: 550px; height: auto;\"/></span><span style=\"text-align: -webkit-center; line-height: 1.5; font-family: &#39;Times New Roman&#39;;\">&nbsp;<span style=\"font-family: ����;\">�����ü�������ʮ�㡢���¡���˥�����ס�פ�յȹ�Ч���ر�ֵ��һ������䱾�������˿�Ƴɣ����������ϻ�������ѡ�ò�˿�����������ص�Ϊ�˿�ѡ��Ȳ�˿�����ᱡ��ϸ������˿�����˿��һ�ֱ���Ʒ�����ں����ֵ������ü�����ø��ӹ⻬��ϸ�壬�����ڲ�˿�ǳ���͸�����ϵĸ��־������ܱ��������õ����գ������</span>��<span style=\"font-family: ����;\">���������Ĥ</span>��<span style=\"font-family: ����;\">֮�ƣ���Ĥ�Ĺ�Ч�������������ף����ܶ�����ʧˮ�����ҵļ���������е����Ӷ��ٽ�ˮ�ֺ����ֵ����ա�</span></span></p><p style=\"white-space: normal; line-height: 25px;\"><strong>��һ��Ĳ�˿��Ĥ��</strong><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/38101430816391084.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/38101430816391084.png\" style=\"text-align: -webkit-center;\"/></p><p style=\"white-space: normal;\">���صĸ߷��ӵ����˿��ά��Ĥ��������������Ȼ��˿��ά������͸��������ڶ��㼡�����෽������ʹ�õ����ʸк�Ч������</p><p style=\"white-space: normal;\">��ϳ���ˮ���������գ��������صľ���Һ����̼�������뼡���ײ㣬Ч���ӳˣ�</p><p style=\"white-space: normal; line-height: 25px;\"><strong>3D����ü����޷�����</strong></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/96271430816421009.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/96271430816421009.png\"/><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/46711430816424443.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/46711430816424443.png\" style=\"text-align: -webkit-center; line-height: 1.5;\"/></p><p style=\"white-space: normal;\">רΪ����Ů���������������Ƶ�3D����ü���ʹ��Ĥ�����е��������㣬�޷�����ÿһ������������ȷ������Һ����׼ȷ���ã���ÿһ�缡����������25ML�ľ����ǳ��޻���</p><p style=\"white-space: normal;\"><span style=\"font-size: 14px; font-family: &#39;Times New Roman&#39;;\"></span></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/48671430816442154.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/48671430816442154.png\"/><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/3691430816458854.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/3691430816458854.png\" style=\"text-align: -webkit-center; line-height: 1.5;\"/></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">����������</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">�������������Լ�ÿ��Ļ���ʱ���ʹ�õĻ���Ʒ���ƣ����ǽ��ڻ�����󣬳�ȡ5��������ÿ�˻��</span><span style=\"color: rgb(60, 60, 60); font-family: tahoma, arial, &#39;Hiragino Sans GB&#39;, ����, sans-serif; font-weight: 700; line-height: 21px; text-align: -webkit-center;\"><span style=\"font-family: ����; font-size: 18px; font-weight: bold; white-space: normal;\">JACQUES&nbsp;ANDHREL��Ч�����Ĥһ��</span></span><span style=\"font-weight: 700; font-size: 15px; letter-spacing: 0px; text-align: -webkit-center; line-height: 1.5;\">��</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">�ʱ�䣺</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">5��</span><span style=\"letter-spacing: 0px; font-size: 15px; font-family: ����;\">11</span><span style=\"letter-spacing: 0px; font-size: 15px;\">��~5��</span><span style=\"letter-spacing: 0px; font-size: 15px; font-family: ����;\">18</span><span style=\"letter-spacing: 0px; font-size: 15px;\">��</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">24Сʱ�������ߣ�4000037993</span></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">�ر�˵����</span><span style=\"letter-spacing: 0px; font-size: 15px;\">�����֯����Ʒ������apple��˾�޹أ�</span></p><p><br/></p>";
//		try {
//			webView.loadDataWithBaseURL(null,new String(string.replaceAll("\r", "").replaceAll("\n", "").getBytes("UTF-8")), "text/html",  "utf-8", null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
