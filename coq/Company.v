Require Import List QArith String.

Section Company.

  Definition salary := Q.
  Inductive employee : Set :=
  | Employee : string -> string -> salary -> employee.
  
  Definition manager := employee.
  
  Inductive department : Set :=
  | Department : string -> manager -> list subunit -> department
  with subunit : Set :=
  | EUnit : employee -> subunit
  | DUnit : department -> subunit.
  
  Inductive company : Set :=
  | Company : string -> list department -> company.

  Section Total.
    Definition sum l := List.fold_left Qplus l 0.

    Definition totalE (e : employee) : Q :=
      match e with
        | Employee _ _ s => s
      end.

    Fixpoint totalSU (su : subunit) : Q :=
      match su with
        | EUnit e => totalE e
        | DUnit d => totalD d
      end
    with totalD (d : department) : Q :=
      match d with
        | Department _ m sus =>
          sum (totalE m :: map totalSU sus)
      end.
    
    Definition total (c : company) : Q :=
      match c with
        Company _ ds => sum (map totalD ds)
      end.
  End Total.
  Section Cut.

    Definition cutE (e : employee) : employee :=
      match e with
        | Employee n a s => Employee n a (Qdiv s (2#1))
      end.

    Fixpoint cutSU (su : subunit) : subunit :=
      match su with
        | EUnit e => EUnit (cutE e)
        | DUnit d => DUnit (cutD d)
      end
    with cutD (d : department) : department :=
      match d with
        | Department n m sus =>
          Department n (cutE m) (map cutSU sus)
      end.

    Definition cutC (c : company) : company :=
      match c with
        | Company n ds => Company n (map cutD ds)
      end.
  End Cut.
  
End Company.

