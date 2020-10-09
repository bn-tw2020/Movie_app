package kr.teamcadi.sideproject;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_like;
    Button btn_dislike;
    TextView likeCountView;
    TextView dislikeCountView;
    Integer likenumber;
    Integer dislikenumber;
    boolean likeState = false;
    boolean dislikeState = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_write = (Button)findViewById(R.id.btn_write);
        Button btn_showALL = (Button)findViewById(R.id.btn_showALL);
        Button btn_buy = (Button)findViewById(R.id.btn_buy);
        Button btn_facebook = (Button)findViewById(R.id.btn_facebook);
        Button btn_kakao = (Button)findViewById(R.id.btn_kakao);
        TextView tv_summary = (TextView)findViewById(R.id.tv_summary);
        TextView tv_director = (TextView)findViewById(R.id.tv_director);
        TextView tv_character = (TextView)findViewById(R.id.tv_character);
        tv_summary.setText("군도, 백성을 구하라\n양반과 탐관오리들의 착취가 극에 달했던 조선 철종 13년.\n힘 없는 백성의 편이 되어 세상을 바로잡고자하는 의적떼인 군도(群島), 지리산 추설이 있었다.\n\n쌍칼 도치 vs 백성의 적 조윤\n잦은 자연재해, 기근과 관의 횡포까지 겹쳐 백성들의 삶이\n날로 피폐해 져 가는 사이, 나주 대부호의 서자로 조선\n최고의 무관 출신인 조윤은 극악한 수법으로 양민들을 수탈,\n삼남지방 최고의 대부호로 성장한다. 한편 소, 돼지를 잡아\n근근이 살아가던 천한 백정 돌무치는 죽어도 잊지 못할\n끔찍한 일을 당한 뒤 군도에 합류, 지리산 추설의 신 거성(新\n巨星) 도치로 거듭난다.\n\n뭉치면 백성, 흩어지면 도적!\n망할 세상을 뒤집기 위해, 백성이 주인인 새 세상을 향해\n도치를 필두로 한 군도는 백성의 적,\n 조윤과 한 판 승부를\n시작하는데...");
        tv_director.setText("윤종빈");
        tv_character.setText("하정우(도치), 강동원(조윤)");


        btn_write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"작성하기눌렀습니다.",Toast.LENGTH_SHORT).show();
            }
        });
        btn_showALL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"모두보기 눌렀습니다..",Toast.LENGTH_SHORT).show();
            }
        });
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"예매하기 눌렀습니다..",Toast.LENGTH_SHORT).show();
            }
        });
        btn_facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"페이스북 눌렀습니다..",Toast.LENGTH_SHORT).show();
            }
        });
        btn_kakao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"카카오톡 눌렀습니다..",Toast.LENGTH_SHORT).show();
            }
        });
        btn_like = (Button) findViewById(R.id.btn_like);
        btn_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeState){
                    decrLikeCount();
                }else{
                    if(dislikeState){
                        decrDisLikeCount();
                        dislikeState = !dislikeState;
                        incrLikeCount();
                    }
                    else{
                        incrLikeCount();
                    }
                }
                likeState = !likeState;
            }
        });
        likeCountView = (TextView) findViewById(R.id.likeCountView);

        btn_dislike = (Button) findViewById(R.id.btn_dislike);

        btn_dislike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dislikeState){
                    decrDisLikeCount();
                }else{
                    if(likeState) {
                        decrLikeCount();
                        likeState = !likeState;
                        incrDisLikeCount();
                    }else{
                        incrDisLikeCount();
                    }
                }
                dislikeState = !dislikeState;
            }
        });
        dislikeCountView = (TextView) findViewById(R.id.dislikeCountView);

        //고치자
        dislikeCountView.setText("15"); likeCountView.setText("3");
        dislikenumber = Integer.parseInt(dislikeCountView.getText()+"");
        likenumber = Integer.parseInt(likeCountView.getText()+"");

        ListView listView = (ListView)findViewById(R.id.listView);
        CommentAdapter adapter = new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**","10분전","적당히 재밌다. 오랜만에 잠 안오는 영화를 봤네요.",3));
        adapter.addItem(new CommentItem("kym71**","12분전","적당히 재밌다. 오랜만에 잠 안오는 영화를 봤네요.",1));
        adapter.addItem(new CommentItem("kym71**","12분전","적당히 재밌다. 오랜만에 잠 안오는 영화를 봤네요.",7));
        listView.setAdapter(adapter);
    }

    class CommentAdapter extends BaseAdapter{
        ArrayList<CommentItem> items = new ArrayList<CommentItem>();
        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem(CommentItem item){
            items.add(item);
        }
        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            CommentItemView views = new CommentItemView(getApplicationContext());

            CommentItem item = items.get(i);
            views.setListId(item.getId());
            views.setListTime(item.getTime());
            views.setListComment(item.getComment());
            views.setListUp(item.getUp());
            return views;
        }
    }

    public void incrLikeCount(){
        likenumber+=1;
        likeCountView.setText(String.valueOf(likenumber));
        btn_like.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }

    public void decrLikeCount(){
        likenumber-=1;
        likeCountView.setText(String.valueOf(likenumber));
        btn_like.setBackgroundResource(R.drawable.thumbs_up_selector);
    }

    public void incrDisLikeCount(){
        dislikenumber+=1;
        dislikeCountView.setText(String.valueOf(dislikenumber));
        btn_dislike.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }

    public void decrDisLikeCount(){
        dislikenumber-=1;
        dislikeCountView.setText(String.valueOf(dislikenumber));
        btn_dislike.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
}