package com.efortshub.holyquran.activities.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.efortshub.holyquran.R;
import com.efortshub.holyquran.databinding.ActivityDownloadManagerBinding;
import com.efortshub.holyquran.interfaces.DownloadFileListener;
import com.efortshub.holyquran.services.CancelDownloadWorkerService;
import com.efortshub.holyquran.utils.HbUtils;
import com.efortshub.holyquran.utils.download_helper.HbDownloadQue;
import com.efortshub.holyquran.utils.download_helper.HbDownloadUtils;

import java.util.List;

/**
 * Created by H. Bappi on  9:36 AM  10/15/21.
 * Contact email:
 * contact@efortshub.com
 * bappi@efortshub.com
 * contact.efortshub@gmail.com
 * github: https://github.com/hbappi
 * Copyright (c) 2021 eFortsHub . All rights reserved.
 **/

public class DownloadManagerActivity extends AppCompatActivity implements DownloadFileListener {
    ActivityDownloadManagerBinding binding;
    public static  DownloadFileListener listener;
    private boolean isActivityRunning = false;



    int oldTheme = R.style.Theme_HBWhiteLight;

    @Override
    protected void onResume() {
        super.onResume();
        isActivityRunning = true;
        if (oldTheme!= HbUtils.getSavedTheme(this)){
            recreate();
        }else {
            listener = this;
            binding.getRoot().post(()-> isActivityRunning = true);
            binding.llDownFinished.setTranslationY(500f);
            checkPendingDownload();

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        oldTheme = HbUtils.getSavedTheme(this);
        setTheme(oldTheme);

        super.onCreate(savedInstanceState);
        binding = ActivityDownloadManagerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        listener = this;
        binding.getRoot().post(()-> isActivityRunning = true);

   /*     HbDownloadUtils.getInstance(this)
                .startDownload("", null, null, null);
*/
        binding.includeTitle.tvTitle.setText(getString(R.string.txt_download_manager));
        binding.includeTitle.btnGoBack.setOnClickListener(v -> onBackPressed());





        binding.btnCancelDownload.setOnClickListener(v -> {
            Intent i = new Intent(DownloadManagerActivity.this, CancelDownloadWorkerService.class);
            startService(i);

        });

        checkPendingDownload();












    }

    private void checkPendingDownload() {
        List<HbDownloadQue.Item> queItem = HbDownloadQue.getInstance(getApplicationContext())
                .enQue(1000);

        if (queItem.size()>0){
            //pending download available
            binding.llSecNoPendingItem.setVisibility(View.GONE);



        }else{
            //no pending item available
            binding.llSecNoPendingItem.setVisibility(View.VISIBLE);


        }



        for (HbDownloadQue.Item dq: queItem){
            Log.d("hhbbhb", "checkPendingDownload: "+dq.getId());
        }








    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onStart() {
        super.onStart();
        isActivityRunning = true;
        listener=this;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        isActivityRunning = true;
        listener =this;
    }


    @Override
    protected void onPause() {
        super.onPause();
        isActivityRunning = false;
        listener = null;
    }

    @Override
    protected void onStop() {
        super.onStop();
        isActivityRunning = false;
        listener = null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isActivityRunning = false;
        listener = null;
    }

    @Override
    public void onDownloadStarted(HbDownloadQue.Item downloadingItem) {
        checkPendingDownload();


    }

    @Override
    public void onDownloadFinished(HbDownloadQue.Item downloadingItem) {

        checkPendingDownload();

        if (downloadingItem==null){
            new Handler(Looper.getMainLooper()).post(() -> {
                binding.llTvPendingDownloadAvailable.setVisibility(View.GONE);
                binding.tvNoPendingDownload.setVisibility(View.VISIBLE);

            });
        }else {

            new Handler(Looper.getMainLooper()).post(() -> {

                binding.tvSubtitleNotify.setText(downloadingItem.getSubtitle());
                binding.tvItemTitleNotify.setText(downloadingItem.getTitle());




                Animation animation = AnimationUtils.loadAnimation(DownloadManagerActivity.this, R.anim.translation_y_to_zero);

                binding.llDownFinished.startAnimation(animation);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        binding.llDownFinished.setTranslationY(0);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Animation n2  = AnimationUtils.loadAnimation(DownloadManagerActivity.this, R.anim.translation_y_to_bottom);


                        new Handler(Looper.getMainLooper())
                                .postDelayed(() -> {

                        binding.llDownFinished.startAnimation(n2);

                        n2.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {

                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                binding.llDownFinished.setTranslationY(500);

                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });




                    }, 4000);

                }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


            });


        }



    }

    @Override
    public void onDownloadProgress(HbDownloadQue.Item downloadingItem, int progress) {


        checkPendingDownload();

        if (isActivityRunning) {

            new Handler(Looper.getMainLooper()).post(()->{

                binding.llTvPendingDownloadAvailable.setVisibility(View.VISIBLE);
                binding.tvNoPendingDownload.setVisibility(View.GONE);

                binding.tvItemTitle.setText(downloadingItem.getTitle());
                binding.tvSubtitle.setText(downloadingItem.getSubtitle());
                binding.pbProgress.setProgress(progress);

            });
        }


        if (binding.llTvPendingDownloadAvailable.getVisibility()==View.GONE){
            recreate();
        }
    }

    @Override
    public void onDownloadFailed(Exception e, boolean isDownloadAlreadyAdded) {

        checkPendingDownload();

    }
}