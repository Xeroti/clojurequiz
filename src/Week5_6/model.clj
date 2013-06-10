(ns Week5-6.model)

(def questions
  [{:vraag "Van welke programmeerparadigma gaat Clojure van uit?" :antwoord "A" :A "Functioneel programmeren" :B "Imperatief programmeren" :C "Procedureel programmeren" :D "Logisch programmeren"} 
   {:vraag "In welke programmeertaal, anders dan Clojure, worden Protocols ook gebruikt?" :antwoord "C" :A "Java" :B "C#" :C "Objective-C" :D "Python"} 
   {:vraag "Waar staat REPL voor?" :antwoord "A" :A "Read Eval Print Loop" :B "Read Execute Print Loop" :C "Relate Execute Print Loop" :D "Read Eval Pass Loop"}
   {:vraag "Hoe zet je commentaar in Clojure?" :antwoord "D" :A "/* */" :B "//" :C "#" :D ";;"}]
  )


(defn iswinner? [vraaga vraagb vraagc vraagd]
  (if(and (= vraaga (get-in questions [0 :antwoord])) (= vraagb (get-in questions [1 :antwoord])) (= vraagc (get-in questions [2 :antwoord])) (= vraagd (get-in questions [3 :antwoord])))
    true
    false
    ))
  
(defn form-filled? [vraaga vraagb vraagc vraagd] 
   (if(or (= nil vraaga) (= nil vraagb) (= nil vraagc) (= nil vraagd))
     true
     false
     ))