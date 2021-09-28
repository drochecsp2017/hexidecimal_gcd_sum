(comment "
    There's an error in here, but it's not giving me enough info to do anything about it...
    
    gets a range of ints from stdin
    calculates the sum of that int's hex representation
    finds the gcd of each int with its hex sum
    prints the number of ints for which the above was > 1
")          

(defn hex_sum [value] 
    (let [hex_base 16]
        (if (i <= 0) 
            0 
            (+ 
                (mod value hex_base) 
                (hex_sum (/ value hex_base))
            )
        )
    )
)

(defn find_num_gcd [current upper]
    (if (current > upper)
        0
        (let [gcd_c (gcd current (hex_sum current))
             rest_of_range (find_num_gcd (inc current) upper)]
            (if (not= gcd_c 1)
                (inc rest_of_range)
                rest_of_range
            )
        )
    )
)

(defn solve_range []
    (let [lower (read-line)
         upper (read-line)]
        (do (println (str (find_num_gcd lower upper))) nil)
    )    
)

; Reading input from STDIN
;(def num_questions (read-line))    
(repeatedly (read-line) solve_range)

; Writing output to STDOUT
;(println (str "Hi, " x "."))        