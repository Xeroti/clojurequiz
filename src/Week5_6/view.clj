(ns Week5-6.view
  (:use Week5-6.model
        Week5-6.controller
        noir.core
        hiccup.core
        hiccup.page
        hiccup.form
        hiccup.util
        hiccup.element)
  (:require [noir.session :as session])
)

(defpartial thequiz [{:keys [vraaga vraagb vraagc vraagd]}]
  [:body
   [:div.main
    [:h2.question-question [:p (get-in (get questions 0) [:vraag])]]
    [:p[:label.answer (radio-button "group1" vraaga "A")]
    [:label (label (get-in (get questions 0) [:A]) (get-in (get questions 0) [:A]))]]
    [:p[:label.answer (radio-button "group1" vraaga "B")]
    [:label (label (get-in (get questions 0) [:B]) (get-in (get questions 0) [:B]))]]
    [:p[:label.answer (radio-button "group1" vraaga "C")]
    [:label (label (get-in (get questions 0) [:C]) (get-in (get questions 0) [:C]))]]
    [:p[:label.answer (radio-button "group1" vraaga "D")]
    [:label (label (get-in (get questions 0) [:D]) (get-in (get questions 0) [:D]))]]
    
    [:h2.question-question [:p (get-in (get questions 1) [:vraag])]]
    [:p[:label.answer (radio-button "group2" vraagb "A")]
    [:label (label (get-in (get questions 1) [:A]) (get-in (get questions 1) [:A]))]]
    [:p[:label.answer (radio-button "group2" vraagb "B")]
    [:label (label (get-in (get questions 1) [:B]) (get-in (get questions 1) [:B]))]]
    [:p[:label.answer (radio-button "group2" vraagb "C")]
    [:label (label (get-in (get questions 1) [:C]) (get-in (get questions 1) [:C]))]]
    [:p[:label.answer (radio-button "group2" vraagb "D")]
    [:label (label (get-in (get questions 1) [:D]) (get-in (get questions 1) [:D]))]]
    
    [:h2.question-question [:p (get-in (get questions 2) [:vraag])]]
    [:p[:label.answer (radio-button "group3" vraagc "A")]
    [:label (label (get-in (get questions 2) [:A]) (get-in (get questions 2) [:A]))]]
    [:p[:label.answer (radio-button "group3" vraagc "B")]
    [:label (label (get-in (get questions 2) [:B]) (get-in (get questions 2) [:B]))]]
    [:p[:label.answer (radio-button "group3" vraagc "C")]
    [:label (label (get-in (get questions 2) [:C]) (get-in (get questions 2) [:C]))]]
    [:p[:label.answer (radio-button "group3" vraagc "D")]
    [:label (label (get-in (get questions 2) [:D]) (get-in (get questions 2) [:D]))]]
    
    [:h2.question-question [:p (get-in (get questions 3) [:vraag])]]
    [:p[:label.answer (radio-button "group4" vraagd "A")]
    [:label (label (get-in (get questions 3) [:A]) (get-in (get questions 3) [:A]))]]
    [:p[:label.answer (radio-button "group4" vraagd "B")]
    [:label (label (get-in (get questions 3) [:B]) (get-in (get questions 3) [:B]))]]
    [:p[:label.answer (radio-button "group4" vraagd "C")]
    [:label (label (get-in (get questions 3) [:C]) (get-in (get questions 3) [:C]))]]
    [:p[:label.answer (radio-button "group4" vraagd "D")]
    [:label (label (get-in (get questions 3) [:D]) (get-in (get questions 3) [:D]))]]
    
    [:p(submit-button "Submit")]]])

(defpage [:any "/"] {:as quiz} []
    (layout
      [:h1 "Quiz"]
            (form-to [:post "/result"]
                    (thequiz quiz)
                    
                    )))
   
(defpage [:post "/result"] {:as quiz} []
    (layout
     (if(form-filled? (:group1 quiz) (:group2 quiz) (:group3 quiz) (:group4 quiz))
       [:h1 "Vul alles in!"]
       [:div
        [:h3 "Antwoord vraag 1: " (:group1 quiz) (if(= (:group1 quiz) (get-in questions [0 :antwoord])) (image "/img/accept.png") (image "/img/decline.png"))]
        [:h3 "Antwoord vraag 2: " (:group2 quiz) (if(= (:group2 quiz) (get-in questions [1 :antwoord])) (image "/img/accept.png") (image "/img/decline.png"))]
        [:h3 "Antwoord vraag 3: " (:group3 quiz) (if(= (:group3 quiz) (get-in questions [2 :antwoord])) (image "/img/accept.png") (image "/img/decline.png"))]
        [:h3 "Antwoord vraag 4: " (:group4 quiz) (if(= (:group4 quiz) (get-in questions [3 :antwoord])) (image "/img/accept.png") (image "/img/decline.png"))]
        (if(iswinner? (:group1 quiz) (:group2 quiz) (:group3 quiz) (:group4 quiz))
          [:h2 "Alle vragen zijn goed beantwoord!"]
          [:h2 "Fout!"])
        ]
       )
     ))