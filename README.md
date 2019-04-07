# wordladder by spring-boot

---

## gitflow workflow

0. 初始化
   清空以前记录

```
git checkout --orphan latest_branch
git add -A
git commit -am "back to hw1"
git branch -D master
git branch -m master
git push -f origin master
```

1. v1.0

```
git tag v1.0
git push origin --tag
```

```
git flow init
```

2. v2.0

```
git flow release start basic-func
git flow release finish basic-func
```

3. v2.1

尝试 hotfix

```
git flow hotfix start basic-cond
git flow hotfix start basic-cond
```

- 为展示流程， publish 了上述 branch
