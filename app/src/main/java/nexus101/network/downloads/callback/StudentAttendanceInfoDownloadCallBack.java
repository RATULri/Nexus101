package nexus101.network.downloads.callback;

import java.util.List;

import nexus101.network.models.Attendance;
import nexus101.network.models.StudentAttendancesInfo;

public interface StudentAttendanceInfoDownloadCallBack {
    void onStudentAttendanceInfoDownloadSuccess(List<Attendance> attendances);
    void onStudentAttendanceInfoDownloadError();
}
