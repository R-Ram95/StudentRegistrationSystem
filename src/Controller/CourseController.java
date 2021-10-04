package Controller;

import Model.CatalogueModel;
import View.CatalogueSearchPage;
import Model.CourseModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseController {
    CatalogueModel model;
    CatalogueSearchPage view;

    public CourseController(CatalogueModel model, CatalogueSearchPage view){
        this.model = model;
        this.view = view;

        view.addActionListener(new CourseListener());
    }
    class CourseListener implements ActionListener {
        String courseName;
        String courseNum;

        @Override
        public void actionPerformed(ActionEvent e) {
            courseName = view.getCourseName();
            courseNum = view.getCourseNumber();
            CourseModel courseFound = model.searchCat(courseName, courseNum);
            if(courseFound!=null){
                int sectionNum = courseFound.getOfferingList();
                view.setCourse(courseName, courseNum);
            }
            }
        }
    }

