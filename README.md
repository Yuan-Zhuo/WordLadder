# wordladder by spring-boot

---

## gitflow workflow

1. 初始化

清空以前记录

```
git checkout --orphan latest_branch
git add -A
git commit -am "back to hw1"
git branch -D master
git branch -m master
git push -f origin master
```

标记

```
git tag v1.0
git push origin --tag
```

gitflow

```
git flow init
```
