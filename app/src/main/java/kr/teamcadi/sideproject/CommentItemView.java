package kr.teamcadi.sideproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 *
 */
public class CommentItemView extends LinearLayout {
    TextView listId;
    TextView listTime;
    TextView listComment;
    TextView listUp;

    public CommentItemView(Context context) {
        super(context);
        init(context);
    }

    public CommentItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view, this,true);

        listId = (TextView)findViewById(R.id.listId);
        listTime = (TextView)findViewById(R.id.listTime);
        listComment = (TextView)findViewById(R.id.listComment);
        listUp = (TextView)findViewById(R.id.listUp);
    }
    public void setListId(String id){
        listId.setText(id);
    }
    public void setListTime(String time){
        listTime.setText(time);
    }
    public void setListComment(String comment){
        listComment.setText(comment);
    }
    public void setListUp(Integer up){
        listUp.setText(up+"");
    }
}
