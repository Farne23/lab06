# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository

   $ git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test
   Cloning into 'OOP-git-merge-conflict-test'...
   remote: Enumerating objects: 12, done.
   remote: Counting objects: 100% (4/4), done.
   remote: Compressing objects: 100% (3/3), done.
   remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8
   Receiving objects: 100% (12/12), done.
   Resolving deltas: 100% (2/2), done.

   $ cd OOP-git-merge-conflict-test/

   $ git status
   On branch master
   Your branch is up to date with 'origin/master'.

   nothing to commit, working tree clean

2. Ci si assicuri di avere localmente entrambi i branch remoti

   $ git branch -v
   * master 8e0f29c Change HelloWorld to print the number of available processors

   $ git branch -r
   origin/HEAD -> origin/master
   origin/feature
   origin/master

   $ git checkout -b feature origin/feature
   Switched to a new branch 'feature'
   Branch 'feature' set up to track remote branch 'feature' from 'origin'.

   $ git branch -v
   * feature bed943f Print author information
     master  8e0f29c Change HelloWorld to print the number of available processors

   $ git status
   On branch feature
   Your branch is up to date with 'origin/feature'.

   nothing to commit, working tree clean

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

   $ git checkout master
   Switched to branch 'master'
   Your branch is up to date with 'origin/master'.

   $ git merge feature
   Auto-merging HelloWorld.java
   CONFLICT (content): Merge conflict in HelloWorld.java
   Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!

   $ git status
   On branch master
   Your branch is up to date with 'origin/master'.

   You have unmerged paths.
   (fix conflicts and run "git commit")
   (use "git merge --abort" to abort the merge)

   Unmerged paths:
   (use "git add <file>..." to mark resolution)
         both modified:   HelloWorld.java

   no changes added to commit (use "git add" and/or "git commit -a")

5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

   $ javac -d bin HelloWorld.java
   $ java -cp bin HelloWorld
   This program is running in a PC with 4 logic processors!
   This program has been realised by Danilo Pianini

   $ git add HelloWorld.java
   
   $ git commit --no-edit
   [master 008724f] Merge branch 'feature'


6. Si crei un nuovo repository nel proprio github personale

7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

   $ git remote add mycopy git@github.com:Farne23/My-OOP-conflict-test.git
   $ git remote -v

   mycopy  git@github.com:Farne23/My-OOP-conflict-test.git (fetch)
   mycopy  git@github.com:Farne23/My-OOP-conflict-test.git (push)

   origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
   origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)   

8. Si faccia push del branch `master` sul proprio repository
9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

   $ git push -u mycopy master
   Enumerating objects: 15, done.
   Counting objects: 100% (15/15), done.
   Delta compression using up to 4 threads
   Compressing objects: 100% (11/11), done.
   Writing objects: 100% (15/15), 1.59 KiB | 816.00 KiB/s, done.
   Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
   remote: Resolving deltas: 100% (4/4), done.
   To github.com:Farne23/My-OOP-conflict-test.git
   * [new branch]      master -> master
   Branch 'master' set up to track remote branch 'master' from 'mycopy'.
