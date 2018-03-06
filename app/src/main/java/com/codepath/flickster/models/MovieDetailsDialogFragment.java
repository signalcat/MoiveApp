package com.codepath.flickster.models;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codepath.flickster.R;

/**
 * Created by hezhang on 9/14/17.
 */

public class MovieDetailsDialogFragment extends DialogFragment {

    private TextView tvRatings;
    //private TextView tvPapularity;

    public MovieDetailsDialogFragment() {
        // Empty constructor is required
    }

    public static MovieDetailsDialogFragment newInstance(String title) {
        MovieDetailsDialogFragment frag = new MovieDetailsDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        frag.setArguments(args);
        return frag;
    }

//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//        String title = getArguments().getString("title");
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
//        alertDialogBuilder.setTitle(title);
//        alertDialogBuilder.setMessage("Are you sure?");
//        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                if (dialog != null ) {
//                    dialog.dismiss();
//                }
//            }
//
//        });
//        return alertDialogBuilder.create();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moviedetails, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get field from view
        tvRatings = (TextView) view.findViewById(R.id.textview_ratings);
        // Fetch arguments from bundle and set title
        String title = getArguments().getString("title", "More about this movie");
        getDialog().setTitle(title);
    }
}

