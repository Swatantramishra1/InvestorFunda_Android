package com.knowledgeflex.investfund.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.knowledgeflex.investfund.ApiService;
import com.knowledgeflex.investfund.Model.DocumentUpload;
import com.knowledgeflex.investfund.Model.UpdateUserDetailsResult;
import com.knowledgeflex.investfund.Model.UserUploadDocumentsMobileResult;
import com.knowledgeflex.investfund.R;
import com.knowledgeflex.investfund.Model.UploadDocumentDetailsDatum;
import com.knowledgeflex.investfund.Model.UserDetailResponse;
import com.knowledgeflex.investfund.Portfolio.OnFragmentInteractionListener;
import com.knowledgeflex.investfund.Utils;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.app.Activity.RESULT_OK;

public class UploadDocument extends Fragment implements OnFragmentInteractionListener, View.OnClickListener {

    public static final String storageConnectionString ="DefaultEndpointsProtocol=https;AccountName=investorfundafile;AccountKey=XTWc5jDFzrI5rX4jEAvXYWRMeSnS5ngrZYlPhv9phyYQXi4PEkg3CIjNnVCbLPCuDy161MYdtJEAPhqv3TeEtg==";
    public static LinearLayout mBaseLayout;
    private Context mContext;
    private int PICK_IMAGE_REQUEST = 1;
    private ArrayList<UploadDocumentDetailsDatum> mDocumentData;
    private TextView mEditDocName;
    private TextView mEditDocType;
    private TextView mEdittDocPath;
    private UserDetailResponse mUserDetailResponse;
    private TextView address;
    private TextView pancard;
    private TextView signature;
    private TextView check;
    Button addressSelect;
    Button pancardSelect;
    Button signatureSelect;
    Button checkSelect;
    Button addressUpload;
    Button pancardUpload;
    Button signatureUpload;
    Button checkUpload;
    Button save;
    String resourceName;
    String imageUriData;
    String picturePath;
    String addressUrl;
    String pancardUrl;
    String checkUrl;
    String signatureUrl;
    String addressUploadId;
    String pancardUploadId;
    String checkUploadId;
    String signatureUploadId;
    private ApiService apiService;
    ProgressDialog progressDialog;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiService = (ApiService) ApiService.retrofit.create(ApiService.class);
        loadCachedData();
    }

    private void loadCachedData() {
        try {
            mUserDetailResponse = (UserDetailResponse) Utils.readObject(mContext, "UserDetails");
            mDocumentData = mUserDetailResponse.getGetUserProfileDetailsInfoResult().getResult().getUploadDocumentDetailsData();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e2) {
            e2.printStackTrace();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_upload_document, container, false);
       // mBaseLayout = (LinearLayout) view.findViewById(R.id.baseLayout);
        if (mDocumentData != null) {
            updateUI();

        }
        address = (TextView)view.findViewById(R.id.addressText);
        pancard = (TextView)view.findViewById(R.id.pancardText);
        signature = (TextView)view.findViewById(R.id.signatureText);
        check = (TextView)view.findViewById(R.id.checkText);
        addressSelect = (Button) view.findViewById(R.id.addressSelect);
        pancardSelect = (Button) view.findViewById(R.id.pancardSelect);
        signatureSelect = (Button) view.findViewById(R.id.signatureSelect);
        checkSelect = (Button) view.findViewById(R.id.checkSelect);
        addressUpload = (Button) view.findViewById(R.id.addressUpload);
        pancardUpload = (Button) view.findViewById(R.id.pancardUpload);
        signatureUpload = (Button) view.findViewById(R.id.signatureUpload);
        checkUpload = (Button) view.findViewById(R.id.checkUpload);
        save = (Button) view.findViewById(R.id.upload_save);

        addressSelect.setOnClickListener(this);
        addressUpload.setOnClickListener(this);
        pancardUpload.setOnClickListener(this);
        pancardSelect.setOnClickListener(this);
        signatureUpload.setOnClickListener(this);
        signatureSelect.setOnClickListener(this);
        checkUpload.setOnClickListener(this);
        checkSelect.setOnClickListener(this);

        return view;
    }

    private void updateUI() {
        LayoutInflater inflat = LayoutInflater.from(mContext);
        for (int index = 0; index < mDocumentData.size(); index++) {
           // View nomineeView = inflat.inflate(R.layout.upload_item_layout, null);
           /* this.mEditDocName = (TextView) nomineeView.findViewById(R.id.documentName);
            this.mEditDocType = (TextView) nomineeView.findViewById(R.id.documentType);
            this.mEdittDocPath = (TextView) nomineeView.findViewById(R.id.documentPath);
            this.mEditDocName.setText(((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentName());
            this.mEditDocType.setText(((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentType());
            this.mEdittDocPath.setText(((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentType());
            mBaseLayout.addView(nomineeView);*/
            String type = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentType();
            String id = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentUploadID();
            switch (type){
                case "Address Details":
                    addressUploadId = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentUploadID();
                    break;
                case "Pan Card":
                    pancardUploadId = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentUploadID();
                    break;
                case "Signature":
                    signatureUploadId = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentUploadID();
                    break;
                case "Cancel Check":
                    checkUploadId = ((UploadDocumentDetailsDatum) this.mDocumentData.get(index)).getDocumentUploadID();
                    break;
                default:
                    break;
            }
           Log.e("address Id",type +" "+id);
           //Log.e("pancardUploadId",pancardUploadId);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onFragmentInteraction(Context mContext) {
        this.mContext = mContext;
     //   mBaseLayout.removeAllViews();
        loadCachedData();
        updateUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.addressSelect:
                   callPhoto();
               // startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;
            case R.id.addressUpload:
                   upload("1");
                break;
            case R.id.pancardSelect:
                callPhoto();
                // startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;
            case R.id.pancardUpload:
                upload("2");
                break;
            case R.id.signatureSelect:
                callPhoto();
                // startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;
            case R.id.signatureUpload:
                upload("3");
                break;
            case R.id.checkSelect:
                callPhoto();
                // startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
                break;
            case R.id.checkUpload:
                upload("4");
                break;
        }
    }

    private void callPhoto() {
        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(i, PICK_IMAGE_REQUEST);
    }

    private void upload(String no) {
        // Use a unigue GUID to avoid collisions.
        UUID uuid1 = UUID.randomUUID();
        resourceName = uuid1.toString();
        try {
              new FileUpload(no).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContext().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            picturePath = cursor.getString(columnIndex);
          //  Log.e("picturePath", picturePath);
            cursor.close();
        }
    }

    class FileUpload extends AsyncTask<Void, Void, Void> {

        String no;

        public FileUpload(String no) {
            this.no = no;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage("Please wait...");
            progressDialog.setCancelable(false);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try
            {
                Uri mPhotoFileUri = Uri.parse(picturePath);
                // Retrieve storage account from connection-string.
                CloudStorageAccount storageAccount = CloudStorageAccount.parse(storageConnectionString);
                // Create the blob client.
                CloudBlobClient blobClient = storageAccount.createCloudBlobClient();
                // Retrieve reference to a previously created container.
                CloudBlobContainer container = blobClient.getContainerReference("investorfunda");
                CloudBlockBlob blob = container.getBlockBlobReference(resourceName+".jpg");
                ///Log.e("Camera",)blob.toString();
                File source = new File(mPhotoFileUri.getPath());
                blob.upload(new FileInputStream(source), source.length());
                imageUriData = blob.getUri().toString();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            try{
               // progressDialog.dismiss();
                switch (no){
                    case "1":
                            addressUrl = imageUriData;
                            updateUrl(addressUrl,addressUploadId);
                        break;
                    case "2":
                            pancardUrl = imageUriData;
                            updateUrl(pancardUrl,pancardUploadId);
                        break;
                    case "3":
                            signatureUrl = imageUriData;
                            updateUrl(signatureUrl,signatureUploadId);
                        break;
                    case "4":
                            checkUrl = imageUriData;
                            updateUrl(checkUrl,checkUploadId);
                        break;
                    default:
                        break;

                }
                //  address.setText(imageUriData);
                Log.e("Data Url",imageUriData);
            }
            catch (Exception e){
                Log.e("Data Upload",e.toString());
            }
        }
    }

    private synchronized void updateUrl(String url, String uploadId) {
        if(new Utils().isNetworkAvailable(getContext())){
            DocumentUpload documentUpload = new DocumentUpload();
            documentUpload.setDocumentPath(url);
            documentUpload.setDocumentUploadId(uploadId);
            apiService.userUploadDocuments(documentUpload).enqueue(new Callback<UserUploadDocumentsMobileResult>() {
                @Override
                public void onResponse(Call<UserUploadDocumentsMobileResult> call, Response<UserUploadDocumentsMobileResult> response) {
                    if(response.code()==200){
                        if (((UserUploadDocumentsMobileResult) response.body()).getGetUploadResult().getResponseCode().intValue() == 0) {
                            progressDialog.dismiss();
                            Toast.makeText(getContext(),((UserUploadDocumentsMobileResult) response.body()).getGetUploadResult().getResult().toString(),Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<UserUploadDocumentsMobileResult> call, Throwable t) {
                    Log.e("Error In upload",t.toString());
                    progressDialog.dismiss();
                }
            });
        }
    }
}
