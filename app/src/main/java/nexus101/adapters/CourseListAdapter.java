package nexus101.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nexus101.R;
import nexus101.admin.course.AdminCourseActivity;
import nexus101.listeners.CourseItemClickListener;
import nexus101.network.models.CourseInfo;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CardViewHolder> {

    Context context;
    List<CourseInfo> courseInfos;
    LayoutInflater inflater;
    CourseItemClickListener courseItemClickListener;

    public CourseListAdapter(Context context, List<CourseInfo> courseInfos, CourseItemClickListener courseItemClickListener) {
        this.context = context;
        this.courseItemClickListener = courseItemClickListener;
        this.courseInfos = courseInfos;
        this.inflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_course_and_group, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListAdapter.CardViewHolder holder, int position) {
        holder.bind(courseInfos.get(position));
    }

    @Override
    public int getItemCount() {
        return courseInfos.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name;

        public CardViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.course_or_group_name);
        }

        public void bind(final CourseInfo courseInfo) {

            tv_name.setText(courseInfo.getCourseName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    courseItemClickListener.onItemClick(courseInfo);
                }
            });

        }
    }
}
