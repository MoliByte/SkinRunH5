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
		// 这样网页就可加载JavaScript了
		settings.setJavaScriptEnabled(true);
		settings.setJavaScriptCanOpenWindowsAutomatically(true);
		settings.setBuiltInZoomControls(false);// 显示放大缩小按钮
		settings.setSupportZoom(false);// 允许放大缩小

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
		 * 用WebView显示图片，可使用这个参数 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：
		 * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
		 */
//		settings.setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
//		settings.setUseWideViewPort(true);
		
		 settings.setLoadWithOverviewMode(true);
		 settings.setUseWideViewPort(true);

		webView.requestFocusFromTouch();
//		webView.loadUrl("http://merchant.skinrun.me");
		webView.loadUrl("http://b.skinrun.me");
//		String string = "<p style=\"text-align: left; white-space: normal;\"><strong style=\"color: rgb(0, 0, 0); font-family: 宋体; line-height: 1.5;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150510/90501431271721571.jpg\" _src=\"http://a.skinrun.cn/jsp/upload/20150510/90501431271721571.jpg\"/></strong></p><p style=\"text-align: left; white-space: normal;\"><strong style=\"color: rgb(0, 0, 0); font-family: 宋体; line-height: 1.5;\">每个人都有自己的护肤时间表，是早上还是晚上，通常都是几点钟护肤呢？都是用哪些护肤品呢？内容越有价值越有机会获奖哦！</strong></p><p style=\"white-space: normal;\"><span style=\"color: rgb(0, 0, 0); font-family: 宋体; font-weight: bold;\"><br/></span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; font-family: 宋体; background-color: rgb(255, 0, 0);\"></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 18px;\"><span style=\"font-weight: bold; font-family: 宋体;\"><span style=\"color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\">本期奖品</span>：</span></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 18px;\"><span style=\"font-weight: bold; font-family: 宋体;\">JACQUES&nbsp;ANDHREL集效金蚕面膜</span><span style=\"font-weight: bold; font-family: 宋体;\">&nbsp;</span></span></p><p style=\"white-space: normal;\"><span style=\"font-size: 14px; font-family: &#39;Times New Roman&#39;;\"></span></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/66261430818315422.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/66261430818315422.png\"/></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/93111430818324874.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/93111430818324874.png\"/><span style=\"font-family: 宋体; font-weight: bold; line-height: 1.5; text-align: -webkit-center; font-size: 18px; color: rgb(255, 255, 255); background-color: rgb(255, 0, 0);\">功效：</span><span style=\"text-align: -webkit-center; line-height: 1.5; font-size: 14px; font-family: &#39;Times New Roman&#39;;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/17181430816361309.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/17181430816361309.png\" style=\"width: 550px; height: auto;\"/></span><span style=\"text-align: -webkit-center; line-height: 1.5; font-family: &#39;Times New Roman&#39;;\">&nbsp;<span style=\"font-family: 宋体;\">可起到让肌肤弹性十足、紧致、抗衰、美白、驻颜等功效，特别值得一提的是其本身用天蚕丝制成，现在市面上基本都是选用蚕丝，所以我们特地为顾客选择比蚕丝更加轻薄、细腻的天蚕丝，天蚕丝是一种保养品，其内涵多种蛋白能让肌肤变得更加光滑、细腻，且由于蚕丝非常薄透，其上的各种精华素能被肌肤更好的吸收，因此有</span>“<span style=\"font-family: 宋体;\">会呼吸的面膜</span>”<span style=\"font-family: 宋体;\">之称，面膜的功效不仅能滋润、美白，还能对因干燥、失水而紊乱的肌肤纹理进行调理，从而促进水分和养分的吸收。</span></span></p><p style=\"white-space: normal; line-height: 25px;\"><strong>非一般的蚕丝面膜布</strong><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/38101430816391084.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/38101430816391084.png\" style=\"text-align: -webkit-center;\"/></p><p style=\"white-space: normal;\">独特的高分子导入蚕丝纤维面膜布，采用三层天然蚕丝纤维，拉伸透气，犹如第二层肌肤，多方面提升使用的舒适感和效果力。</p><p style=\"white-space: normal;\">配合成熟水刺制作工艺，紧锁满载的精华液，顷刻间帮助渗入肌肤底层，效果加乘！</p><p style=\"white-space: normal; line-height: 25px;\"><strong>3D立体裁剪，无缝贴合</strong></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/96271430816421009.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/96271430816421009.png\"/><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/46711430816424443.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/46711430816424443.png\" style=\"text-align: -webkit-center; line-height: 1.5;\"/></p><p style=\"white-space: normal;\">专为亚洲女性脸部轮廓量身定制的3D立体裁剪，使面膜犹如有地心吸力般，无缝贴合每一寸脸部肌肤，确保精华液发挥准确作用，让每一寸肌肤都沉醉于25ML的精华呵宠修护！</p><p style=\"white-space: normal;\"><span style=\"font-size: 14px; font-family: &#39;Times New Roman&#39;;\"></span></p><p style=\"white-space: normal;\"><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/48671430816442154.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/48671430816442154.png\"/><img style=\"width:100%;height:auto\" src=\"http://a.skinrun.cn/jsp/upload/20150505/3691430816458854.png\" _src=\"http://a.skinrun.cn/jsp/upload/20150505/3691430816458854.png\" style=\"text-align: -webkit-center; line-height: 1.5;\"/></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">申领条件：</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">在帖子下留下自己每天的护肤时间和使用的护肤品名称，我们将在活动结束后，抽取5名申领者每人获得</span><span style=\"color: rgb(60, 60, 60); font-family: tahoma, arial, &#39;Hiragino Sans GB&#39;, 宋体, sans-serif; font-weight: 700; line-height: 21px; text-align: -webkit-center;\"><span style=\"font-family: 宋体; font-size: 18px; font-weight: bold; white-space: normal;\">JACQUES&nbsp;ANDHREL集效金蚕面膜一盒</span></span><span style=\"font-weight: 700; font-size: 15px; letter-spacing: 0px; text-align: -webkit-center; line-height: 1.5;\">。</span></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">活动时间：</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">5月</span><span style=\"letter-spacing: 0px; font-size: 15px; font-family: 宋体;\">11</span><span style=\"letter-spacing: 0px; font-size: 15px;\">日~5月</span><span style=\"letter-spacing: 0px; font-size: 15px; font-family: 宋体;\">18</span><span style=\"letter-spacing: 0px; font-size: 15px;\">日</span></p><p style=\"white-space: normal;\"><span style=\"letter-spacing: 0px; font-size: 15px;\">24小时服务热线：4000037993</span></p><p style=\"white-space: normal;\"><br/></p><p style=\"white-space: normal;\"><span style=\"color: rgb(255, 255, 255); letter-spacing: 0px; font-weight: bold; font-size: 18px; background-color: rgb(255, 0, 0);\">特别说明：</span><span style=\"letter-spacing: 0px; font-size: 15px;\">本活动组织及奖品发放与apple公司无关！</span></p><p><br/></p>";
//		try {
//			webView.loadDataWithBaseURL(null,new String(string.replaceAll("\r", "").replaceAll("\n", "").getBytes("UTF-8")), "text/html",  "utf-8", null);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
